package singleton;

public class LazySingleton {

    private static LazySingleton instance;

    private static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
