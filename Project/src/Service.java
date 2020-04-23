import car.Car;
import car.CarModel;
import client.Client;
import client.Individual;
import client.LegalEntity;
import io.ReadCSV;

public class Service {

    public static void main(String[] args) {

        ShoppingService shoppingService = new ShoppingService();
        ClientService clientService = new ClientService();
        ReadCSV readCSV = new ReadCSV();

        //Read the Cars from the CSV files and returns an Array of Cars
        Car[] cars = readCSV.readCar();

        Client client1 = new Individual("Bogdan",200000,4);
        Client client2 = new Individual("Elon",20000,1);
        Client company1 = new LegalEntity("Elon",345000,21,"SpaceX");

        Store bucharestStore = shoppingService.createStore(10);

        ShoppingCart client1Cart = shoppingService.createShoppingCart(client1);
        ShoppingCart client2Cart = shoppingService.createShoppingCart(client2);
        ShoppingCart company1Cart = shoppingService.createShoppingCart(company1);

        shoppingService.addCarToStore(bucharestStore, cars[0]);
        shoppingService.addCarToStore(bucharestStore, cars[1]);
        shoppingService.addCarToStore(bucharestStore, cars[2]);
        shoppingService.addCarToStore(bucharestStore, cars[3]);
        shoppingService.addCarToStore(bucharestStore, cars[4]);
        shoppingService.addCarToStore(bucharestStore, cars[5]);

        shoppingService.showCarsInStore(bucharestStore);

        shoppingService.addCarToShoppingCart(client1Cart, shoppingService.getCarFromStore(bucharestStore, 1));
        shoppingService.addCarToShoppingCart(client1Cart, shoppingService.getCarFromStore(bucharestStore, 3));

        shoppingService.showCarsInCart(client1Cart);

        clientService.buyCart(bucharestStore, client1Cart);

        shoppingService.showCarsInStore(bucharestStore);

        shoppingService.addCarToShoppingCart(client2Cart, shoppingService.getCarFromStore(bucharestStore, 0)); //dubios, nu vrea sa mearga pentru index 2

        clientService.buyCart(bucharestStore, client2Cart);

        try {
            Review reviewClient2 = clientService.giveReview(shoppingService.getCarFromStore(bucharestStore, 0), client2, 5, "Too expensive");
        }
        catch (RuntimeException e){
            System.out.println(e);
        }

    }
}
