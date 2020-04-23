import car.Car;
import client.Client;

public class ShoppingCart {

    private int index;
    private int maxCapacity;
    private Car[] cars;
    private int totalCost;
    private Client client;

    public ShoppingCart(Client client) {
        this.index = 0;
        this.maxCapacity = 10;
        this.totalCost = 0;
        this.cars = new Car[maxCapacity];
        this.client = client;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getIndex() {
        return index;
    }

    public Client getClient(){
        return client;
    }

    public void addCar(Car car) {
        if(index == maxCapacity) {
            //throw new RuntimeException("Your shopping cart is full!");
            System.out.println("Your shopping cart is full!");
        }
        else {
            cars[index] = car;

            this.totalCost += car.getCost();

            index += 1;
        }
    }

    public Car[] listShoppingCart() {
        return cars;
    }

    public void delete(int index) {
        if(index < 0 || index > maxCapacity) {
            //throw new RuntimeException("The number must be a positive integer in the range [0, size)");
            System.out.println("The number must be a positive integer in the range [0, size)");
        }
        else {

            if (maxCapacity - 1 - index >= 0)
                System.arraycopy(cars, index + 1, cars, index, maxCapacity - 1 - index);

            maxCapacity -= 1;
        }
    }
}
