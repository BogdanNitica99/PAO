package singleton;

public class ConcurrentLazySingleton {

    /* using volatile because reference return may happen before object constructed
     * volatile keyword guarantees visibility of changes to variables across threads (read and write from main memory)
     */
    private static volatile ConcurrentLazySingleton instance;

    // private constructor
    private ConcurrentLazySingleton() {
    }

    public ConcurrentLazySingleton getInstance() {
        if(instance == null) {
            synchronized (ConcurrentLazySingleton.class) {
                // double check
                if(instance == null) {
                    instance = new ConcurrentLazySingleton();
                }
            }
        }
        return instance;
    }
}
