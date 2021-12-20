package singleton;

public class LazySingleton {

    /*
   첫 번째 if 문으로 인스턴스의 존재여부를 체크하고 두 번째 if 문에서 다시 한번 체크할 때 동기화 시켜서 인스턴스를
   생성하므로 thread-safe 하면서도 처음 생성 이후에 synchronized 블럭을 타지 않기 때문에 성능저하를 완화했다.
   */

    private volatile static LazySingleton sLazySingleton;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (sLazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (sLazySingleton == null) {
                    sLazySingleton = new LazySingleton();
                }
            }

        }
        return sLazySingleton;
    }
}
