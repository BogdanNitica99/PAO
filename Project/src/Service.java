import java.util.StringJoiner;

public class Service {

    public static void main(String[] args) {

        Client client1 = new Individual("Bogdan",200000,4);
        Client client2 = new Individual("Elon",20000,1);
        Client company1 = new LegalEntity("Elon",345000,21,"SpaceX");

        Store bucharestStore = new Store(10);

        ShoppingCart client1Cart = new ShoppingCart(client1);
        ShoppingCart client2Cart = new ShoppingCart(client2);
        ShoppingCart company1Cart = new ShoppingCart(company1);

        CarModel dacia = new CarModel("Dacia", "Logan", "Sedan");
        CarModel audi = new CarModel("Audi","A4","Sedan");
        CarModel tesla = new CarModel("Tesla","Model S","Sedan");

        Car daciaWhite = new Car(dacia,7000,99,"White");
        Car teslaRed = new Car(tesla,90000,300,"Red");
        Car teslaBlue = new Car(tesla,90000,300,"Blue");
        Car audiBlack = new Car(audi, 30000, 190, "Black");

        bucharestStore.addCar(daciaWhite);
        bucharestStore.addCar(teslaRed);
        bucharestStore.addCar(teslaBlue);
        bucharestStore.addCar(audiBlack);

        //bucharestStore.sortCars();

        Car[] cars = bucharestStore.listStoreCars();

        System.out.println("Cars in Store");
        for (int i=0;(i<cars.length)  && (cars[i] != null);i++) {
            System.out.println(cars[i]);
        }

        client1Cart.addCar(cars[1]);
        client1Cart.addCar(cars[3]);

        System.out.println("My cart: ");
        Car[] carsInCart = client1Cart.listShoppingCart();
        for (int i=0;(i<carsInCart.length) && (carsInCart[i] != null);i++) {
            System.out.println(carsInCart[i]);
        }

        buyCart(bucharestStore, client1Cart);

        System.out.println("Cars in Store");
        for (int i=0;(i<cars.length)  && (cars[i] != null);i++) {
            System.out.println(cars[i]);
        }

        client2Cart.addCar(cars[0]);
        buyCart(bucharestStore, client2Cart);

        Review reviewClient2 = new Review(cars[0], client2,5,"Too expensive");

    }

    public static void buyCart(Store store, ShoppingCart cart) {
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
