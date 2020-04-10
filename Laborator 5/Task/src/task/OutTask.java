package task;

public class OutTask implements Task {

    private String message;

    public OutTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
    }
}
