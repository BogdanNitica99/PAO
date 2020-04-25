import car.Car;
import client.Client;
import io.ReadCSV;
import io.WriteCSV;
import services.Receipt;
import services.Review;

import java.io.IOException;

public class Service {

    public static void main(String[] args) {

        ReadCSV readCSV = new ReadCSV();
        WriteCSV writeCSV = new WriteCSV();

        ShoppingService shoppingService = new ShoppingService();
        ClientService clientService = new ClientService();

        //Read the Cars from the CSV files and returns an Array of Cars
        Car[] cars = readCSV.readCar();
        //Read the Clients from the CSV files and returns an Array of Clients
        Client[] clients = readCSV.readClient();

        Store bucharestStore = shoppingService.createStore(10);

        ShoppingCart client1Cart = shoppingService.createShoppingCart(clients[0]);
        ShoppingCart client2Cart = shoppingService.createShoppingCart(clients[1]);
        ShoppingCart company1Cart = shoppingService.createShoppingCart(clients[2]);

        shoppingService.addCarToStore(bucharestStore, cars[0]);
        shoppingService.addCarToStore(bucharestStore, cars[1]);
        shoppingService.addCarToStore(bucharestStore, cars[2]);
        shoppingService.addCarToStore(bucharestStore, cars[3]);
        shoppingService.addCarToStore(bucharestStore, cars[4]);
        shoppingService.addCarToStore(bucharestStore, cars[5]);

        //Print all the Cars in the Store
        shoppingService.showCarsInStore(bucharestStore);

        shoppingService.addCarToShoppingCart(client1Cart, shoppingService.getCarFromStore(bucharestStore, 1));
        shoppingService.addCarToShoppingCart(client1Cart, shoppingService.getCarFromStore(bucharestStore, 3));

        //Print all the Cars in the Shopping Cart for Client1
        shoppingService.showCarsInCart(client1Cart);

        Receipt receiptClient1 = clientService.buyCart(bucharestStore, client1Cart);

        shoppingService.showCarsInStore(bucharestStore);

        shoppingService.addCarToShoppingCart(client2Cart, shoppingService.getCarFromStore(bucharestStore, 0)); //dubios, nu vrea sa mearga pentru index 2

        Receipt receiptClient2 = clientService.buyCart(bucharestStore, client2Cart);

        try {
            Review reviewClient2 = clientService.giveReview(shoppingService.getCarFromStore(bucharestStore, 0), clients[1], 5, "Too expensive");
            writeCSV.writeReview(reviewClient2);
        }
        catch (RuntimeException | IOException e){
            System.out.println(e);
        }

        try {
            writeCSV.writeReceipt(receiptClient1);
            writeCSV.writeReceipt(receiptClient2);
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
}
