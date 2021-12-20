package Synchronization;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class StaticMethod {

    public static void main(String[] args) {
        StaticMethod staticMethod = new StaticMethod();

        Thread thread1 = new Thread(() -> {
            System.out.println("스레드1 시작 " + LocalDateTime.now());
            syncStaticMethod1("스레드1");
            System.out.println("스레드1 종료 " + LocalDateTime.now());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("스레드2 시작 " + LocalDateTime.now());
            syncStaticMethod2("스레드2");
            System.out.println("스레드2 종료 " + LocalDateTime.now());
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("스레드3 시작 " + LocalDateTime.now());
            staticMethod.syncMethod3("스레드3");
            System.out.println("스레드3 종료 " + LocalDateTime.now());
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static synchronized void syncStaticMethod1(String msg) {
        System.out.println(msg + "의 syncStaticMethod1 실행중" + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void syncStaticMethod2(String msg) {
        System.out.println(msg + "의 syncStaticMethod2 실행중" + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void syncMethod3(String msg) {
        System.out.println(msg + "의 syncMethod3 실행중" + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
