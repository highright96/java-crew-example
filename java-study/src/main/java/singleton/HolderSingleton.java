package singleton;

/*
개발자가 직접 동기화 문제에 대해 코드를 작성하고 문제를 회피하려 한다면 프로그램 구조가 그 만큼 복잡해지고 비용 문제가 생길 수 있고 특히 정확하지 못한 경우가 많다.
이 방법은 JVM 의 클래스 초기화 과정에서 보장되는 원자적 특성을 이용해 싱글톤의 초기화 책임을 JVM 에게 넘길 수 있다.

그냥 EagerSingleton 에 final 을 붙이면 되지 않을까? 의문이 들 것이다.

이 부분은 JVM 공부가 필요하다.
static final 로 기술할 경우 해당 클래스가 로드될 때 사용하지 않아도 싱글톤 변수가 로드되기 때문에 메모리가 낭비된다. 그러나 내부 클래스인 Holder 클래스에
싱글톤 변수를 할당하면 getInstance() 로 접근할 때 할당되므로 메모리 낭비가 일어나지 않는다.
*/

public class HolderSingleton {

    private HolderSingleton() {
    }

    public static HolderSingleton getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        public static final HolderSingleton instance = new HolderSingleton();
    }
}
