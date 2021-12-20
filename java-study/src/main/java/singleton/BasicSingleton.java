package singleton;

import java.util.Objects;

public class BasicSingleton {

    /*
    싱글 스레드 환경에서는 문제가 없지만 멀티 스레드 환경일 경우 getInstance() 가 동시에 불릴 수 있다.
    synchronized 를 이용하면 간단히 해결 가능하지만, 비용이 비싸기 때문에 다른 방법을 많이 사용한다.
    */

    private static BasicSingleton sBasicSingleton;

    public static synchronized BasicSingleton getInstance() {
        if (Objects.isNull(sBasicSingleton)) {
            sBasicSingleton = new BasicSingleton();
        }
        return sBasicSingleton;
    }
}
