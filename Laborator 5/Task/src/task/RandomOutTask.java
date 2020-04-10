package task;

import java.util.Random;

public class RandomOutTask implements Task {

    private int number;

    public RandomOutTask() {
        number = new Random().nextInt();
    }

    @Override
    public void run() {
        System.out.println("Random number: " + number);
    }
}
