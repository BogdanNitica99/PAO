import car.Car;
import client.Client;

public class ClientService {

    public Review giveReview(Car car, Client client, int stars, String feedback) {
        Review review = new Review(car, client, stars, feedback);
        return review;
    }

    public void buyCart(Store store, ShoppingCart cart) {
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
            return;
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

        receipt = new Receipt("20 Mar", 5,carCosts,carsBought,numberOfCars,client,clientDiscount);

        System.out.println("Your receipt: ");
        System.out.println(receipt.toString());
    }

}
