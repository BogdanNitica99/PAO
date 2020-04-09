package whyuseinterfaces.example1;

import whyuseinterfaces.example3.CoffeeCup;
import whyuseinterfaces.example3.Cup;
import whyuseinterfaces.example3.TeaCup;

public class VirtualCoffee {

    public static void prepareCup(Cup cup) {
        cup.wash();
    }

    public static void main(String[] args) {
        Cup cup = new Cup();
        prepareCup(cup);

        // dynamic polymorphism
        Cup coffeeCup = new CoffeeCup();
        prepareCup(coffeeCup);

        // dynamic polymorphism
        Cup teaCup = new TeaCup();
        prepareCup(teaCup);
    }
}
