public class Service {

    public static void main(String[] args) {

        Store bucharestStore = new Store(10);
        ShoppingCart myCart = new ShoppingCart();

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

        Car[] cars = bucharestStore.listStoreCars();

        System.out.println("Cars in Store");
        for (int i=0;(i<cars.length)  && (cars[i] != null);i++) {
            System.out.println(cars[i]);
        }

        myCart.addCar(cars[1]);
        myCart.addCar(cars[3]);

        System.out.println("My cart: ");
        Car[] carsInCart = myCart.listShoppingCart();
        for (int i=0;(i<carsInCart.length) && (carsInCart[i] != null);i++) {
            System.out.println(carsInCart[i]);
        }

        buyCart(bucharestStore, myCart);

        System.out.println("Cars in Store");
        for (int i=0;(i<cars.length)  && (cars[i] != null);i++) {
            System.out.println(cars[i]);
        }

    }

    public static void buyCart(Store store, ShoppingCart cart) {
        Car[] carsInCart = cart.listShoppingCart();

        for (int i=0;(i<carsInCart.length) && (carsInCart[i] != null);i++) {
            int index = store.findCar(carsInCart[i]);
            store.delete(index);
        }
    }

}
