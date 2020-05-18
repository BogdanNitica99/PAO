package whyuseinterfaces.example2;

import whyuseinterfaces.example3.*;

public class Cleaner {

    public static void cleanObject(Object object) {
        if (object instanceof Car) {
            Car car = (Car) object;
            car.wash();
        } else if (object instanceof Window) {
            Window window = (Window) object;
            window.wash();
        } else if (object instanceof Cup) {
            Cup cup = (Cup) object;
            cup.wash();
        } else if (object instanceof Dog) {
            Dog dog = (Dog) object;
            dog.wash();
        } else {
            throw new RuntimeException("unsupported object type");
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        cleanObject(dog);

        Window window = new Window();
        cleanObject(window);

        Car car = new Car();
        cleanObject(car);

        Cup cup = new CoffeeCup();
        cleanObject(cup);

        String unknownType = "unknown type";
        cleanObject(unknownType); // throws exception
    }
}
