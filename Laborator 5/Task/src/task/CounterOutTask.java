package task;

public class CounterOutTask implements Task {

    private static int counter;

    public CounterOutTask() {
        counter = 0;
    }

    @Override
    public void run() {
        counter += 1;
        System.out.println("Counter: " + counter);
    }
}
