import client.Client;
import client.Individual;
import client.LegalEntity;

public class Service {

    public static void main(String[] args) {

        ShoppingService shoppingService = new ShoppingService();
        ClientService clientService = new ClientService();

        Client client1 = new Individual("Bogdan",200000,4);
        Client client2 = new Individual("Elon",20000,1);
        Client company1 = new LegalEntity("Elon",345000,21,"SpaceX");

        Store bucharestStore = shoppingService.createStore(10);

        ShoppingCart client1Cart = shoppingService.createShoppingCart(client1);
        ShoppingCart client2Cart = shoppingService.createShoppingCart(client2);
        ShoppingCart company1Cart = shoppingService.createShoppingCart(company1);

        CarModel dacia = new CarModel("Dacia", "Logan", "Sedan");
        CarModel audi = new CarModel("Audi","A4","Sedan");
        CarModel tesla = new CarModel("Tesla","Model S","Sedan");

        Car daciaWhite = new Car(dacia,7000,99,"White");
        Car teslaRed = new Car(tesla,90000,300,"Red");
        Car teslaBlue = new Car(tesla,90000,300,"Blue");
        Car audiBlack = new Car(audi, 30000, 190, "Black");

        shoppingService.addCarToStore(bucharestStore, daciaWhite);
        shoppingService.addCarToStore(bucharestStore, teslaRed);
        shoppingService.addCarToStore(bucharestStore, teslaBlue);
        shoppingService.addCarToStore(bucharestStore, audiBlack);

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
