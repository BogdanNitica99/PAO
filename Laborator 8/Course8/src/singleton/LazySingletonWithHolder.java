package singleton;

public class LazySingletonWithHolder {

    // private constructor
    private LazySingletonWithHolder() {
    }

    // static nested class
    public static class SingletonHolder {
        /* instance will be initialised only when required
         * advantage --> you can load the LazySingletonWithHolder class and use static variables
         * is also thread safe */
        private static final LazySingletonWithHolder INSTANCE = new LazySingletonWithHolder();
    }

    public static LazySingletonWithHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
