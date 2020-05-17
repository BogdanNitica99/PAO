package singleton;

public class EagerSingleton {

    // initialised on class loading
    private static EagerSingleton instance;

    static {
        instance = new EagerSingleton();
    }

    //private constructor
    private EagerSingleton() {
    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}
