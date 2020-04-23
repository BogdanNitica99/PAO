package singleton;

public class EagerSingleton {

    private static EagerSingleton instance;

    static {
        instance = new EagerSingleton();
    }

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
