import car.Car;
import client.Client;
import io.LogCSV;
import services.Receipt;
import services.Review;

public class ClientService {

    LogCSV logCSV = new LogCSV();

    public Review giveReview(int carId, int clientId, int stars, String feedback) {
        Review review = new Review(carId, clientId, stars, feedback);

        logCSV.writeLog(clientId + " left a review for car");

        return review;
    }

    public Receipt buyCart(Store store, ShoppingCart cart) {
        Car[] carsInCart = cart.listShoppingCart();
        Client client = cart.getClient();
        int clientMoney = client.getMoney();
        int clientDiscount = client.getDiscount();

        int carCosts = cart.getTotalCost();

        if(clientDiscount > 0) {
            carCosts = carCosts - (clientDiscount*100);
        }

        if(clientMoney >= carCosts){
            System.out.println("You have enough money!");
        }
        else {
            System.out.println("You don't have enough money!");
            return null;
        }

        Receipt receipt;
        int numberOfCars = 0;
        Car[] carsBought;

        for (int i=0;(i<carsInCart.length) && (carsInCart[i] != null);i++) {
            numberOfCars += 1;
        }

        carsBought = new Car[numberOfCars];

        for (int i=0;i<numberOfCars;i++) {
            carsBought[i] = carsInCart[i];
            int index = store.findCar(carsInCart[i]);
            store.delete(index);
        }

        receipt = new Receipt(5,carCosts,carsBought,numberOfCars,0,clientDiscount, "2");
        System.out.println("Your receipt: ");
        System.out.println(receipt.writeNice());

        logCSV.writeLog(client.getName() + " bought his Shopping Cart");
        logCSV.writeLog(client.getName() + " got a receipt costing " + carCosts);

        return receipt;
    }

}
