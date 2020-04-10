import container.Container;
import container.Queue;
import container.Stack;
import task.CounterOutTask;
import task.OutTask;
import task.RandomOutTask;

public class TestTask {

    public static void main(String[] args) {

        Container stackContainer = new Stack();
        Container queueContainer = new Queue();

        System.out.println("Stack container!");
        testTasks(stackContainer);
        System.out.println("Queue container!");
        testTasks(queueContainer);

    }

    private static void testTasks(Container container) {
        container.addTask(new OutTask("Hello"));
        container.addTask(new RandomOutTask());
        container.addTask(new CounterOutTask());
        container.addTask(new OutTask("Hello World"));
        container.addTask(new CounterOutTask());

        while(container.hasTask()) {
            container.runTask();
        }
    }
}
