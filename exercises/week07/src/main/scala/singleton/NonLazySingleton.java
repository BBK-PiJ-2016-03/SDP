package singleton;

/**
 * Created by aworton on 27/02/17.
 */
public enum NonLazySingleton {
    INSTANCE;

    int id = 0;

    public synchronized int getNextId() {
        return ++INSTANCE.id;
    }
}
