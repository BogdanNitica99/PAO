package whyuseinterfaces.example4;

import whyuseinterfaces.Washable;
import whyuseinterfaces.model.cup.Cup;
import whyuseinterfaces.model.vehicle.Car;

public class Test2 {

    public static void clean(Washable washable) {
        washable.wash();
    }

    public static void main(String[] args) {
        // use a reference of the same type as the object created
        Cup cup = new Cup();
        clean(cup);

        // use an interface reference for the object created
        Washable car = new Car();
        clean(car);


        // interface reference with an object of an anonymous class
        Washable washableAnonymous = new Washable() { /*here starts the body of the anonymous class*/
            //can define additional fields and methods
            String name = "anonymous class";

            void printMe() {
                // check the unusual type of this class: current class name, followed by a $ sign, then a number
                System.out.println("Class: " + this + ", name: " + name);
            }

            // implement the abstract method inherited from interface
            @Override
            public void wash() {
                printMe();
                System.out.println("wash anonymous object");
            }
        };
        washableAnonymous.wash();


        Washable evolvedCar = new Car() {
            // we can reimplement here the behavior
            @Override
            public void wash() {
                System.out.println("washing a new car whyuseinterfaces.model");
            }
        };
        evolvedCar.wash();
    }
}
