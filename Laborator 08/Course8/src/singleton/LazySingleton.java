package singleton;

public class LazySingleton {

    private static LazySingleton instance;

    // private constructor
    private LazySingleton() {
    }

    // initialised on getInstance()
    public static LazySingleton getInstance() {
        // not thread-safe
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
