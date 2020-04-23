import car.Car;
import client.Client;

public class ShoppingService {

    public ShoppingCart createShoppingCart(Client client) {
        ShoppingCart shoppingCart = new ShoppingCart(client);
        return shoppingCart;
    }

    public void addCarToShoppingCart(ShoppingCart shoppingCart, Car car) {
        shoppingCart.addCar(car);
    }

    public void showCarsInCart(ShoppingCart shoppingCart) {
        System.out.println("My cart: ");
        Car[] carsInCart = shoppingCart.listShoppingCart();
        for (int i=0;(i<carsInCart.length) && (carsInCart[i] != null);i++) {
            System.out.println(carsInCart[i]);
        }
    }

    public Store createStore(int maxCapacity){
        Store store = new Store(maxCapacity);
        return store;
    }

    public void addCarToStore(Store store, Car car) {
        store.addCar(car);
    }

    public void showCarsInStore(Store store) {
        System.out.println("Cars in Store");
        Car[] cars = store.listStoreCars();
        for (int i=0;(i<cars.length)  && (cars[i] != null);i++) {
            System.out.println(cars[i]);
        }
    }

    public Car getCarFromStore(Store store, int index) {
        Car[] cars = store.listStoreCars();
        if((index < cars.length) && (cars[index] != null)) {
            return cars[index];
        }
        return null;
    }

}
