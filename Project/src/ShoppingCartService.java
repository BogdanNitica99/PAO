import client.Client;

public class ShoppingCartService {

    Client client;
    Store store;
    ShoppingCart shoppingCart;

    public ShoppingCartService(Client client, Store store) {
        this.client = client;
        this.store = store;
    }

    public void addCartToShoppingCart(Car car) {
        try {
            shoppingCart.addCar(car);
        }
        catch (RuntimeException e){
            System.out.println(e);
        }
    }

    



}
