package singleton;

public class EagerSingleton {

    private static EagerSingleton sEagerSingleton = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return sEagerSingleton;
    }
}
