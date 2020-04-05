import java.util.Arrays;
import java.util.Comparator;

public class Store {

    private Car[] cars;
    private int index;
    private int maxCapacity;

    public Store(int maxCapacity) {
        cars = new Car[maxCapacity];
        this.maxCapacity = maxCapacity;
        this.index = 0;
    }

    public void addCar(Car car) {
        if(index == maxCapacity) {
            throw new RuntimeException("Your shopping cart is full!");
        }
        else {
            cars[index] = car;

            index += 1;
        }
    }

    public void sortCars() {
        Arrays.sort(this.cars);
    }

    public Car[] listStoreCars() {
        return cars;
    }

    public int findCar(Car findCar) {
        for(int i=0;i<(cars.length)  && (cars[i] != null);i++) {
            if(findCar.equals(cars[i])) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int index) {
        if(index < 0 || index > maxCapacity) {
            throw new RuntimeException("The number must be a positive integer in the range [0, size)");
        }

        if (maxCapacity - 1 - index >= 0)
            System.arraycopy(cars, index + 1, cars, index, maxCapacity - 1 - index);

        maxCapacity -= 1;
    }
}
