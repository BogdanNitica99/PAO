package singleton;

public class ConcurrentLazySingleton {

    private static volatile ConcurrentLazySingleton instance;

    private ConcurrentLazySingleton() {

    }

    public ConcurrentLazySingleton getInstance() {
        if(instance == null) {
            synchronized (ConcurrentLazySingleton.class) {
                if(instance == null) {
                    instance = new ConcurrentLazySingleton();
                }
            }
        }
        return instance;
    }
}
