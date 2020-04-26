import car.Car;
import client.Client;
import io.LogCSV;

public class ShoppingService {

    LogCSV logCSV = new LogCSV();

    public ShoppingCart createShoppingCart(Client client) {
        ShoppingCart shoppingCart = new ShoppingCart(client);

        logCSV.writeLog("Shopping Cart created for " + client.getName());

        return shoppingCart;
    }

    public void addCarToShoppingCart(ShoppingCart shoppingCart, Car car) {

        logCSV.writeLog("Car added to " + shoppingCart.getClient().getName());

        shoppingCart.addCar(car);
    }

    public void showCarsInCart(ShoppingCart shoppingCart) {
        System.out.println("My cart: ");
        Car[] carsInCart = shoppingCart.listShoppingCart();
        for (int i=0;(i<carsInCart.length) && (carsInCart[i] != null);i++) {
            System.out.println(carsInCart[i].writeToCSV());
        }

        logCSV.writeLog("Show cars in Cart for " + shoppingCart.getClient().getName());

    }

    public Store createStore(int maxCapacity){
        Store store = new Store(maxCapacity);

        logCSV.writeLog("Created Store with " + maxCapacity + " capacity");

        return store;
    }

    public void addCarToStore(Store store, Car car) {
        store.addCar(car);

        logCSV.writeLog("Car added to the store");
    }

    public void showCarsInStore(Store store) {
        System.out.println("Cars in Store");
        Car[] cars = store.listStoreCars();
        for (int i=0;(i<cars.length)  && (cars[i] != null);i++) {
            System.out.println(cars[i].writeToCSV());
        }

        logCSV.writeLog("Show cars in Store");
    }

    public Car getCarFromStore(Store store, int index) {
        Car[] cars = store.listStoreCars();

        logCSV.writeLog("Return car from store");

        if((index < cars.length) && (cars[index] != null)) {
            return cars[index];
        }
        return null;
    }

}
