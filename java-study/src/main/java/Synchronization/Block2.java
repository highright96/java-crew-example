package Synchronization;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Block2 {

    private final Object o1 = new Object();
    private final Object o2 = new Object();

    public static void main(String[] args) {
        Block2 block = new Block2();

        Thread thread1 = new Thread(() -> {
            System.out.println("스레드1 시작 " + LocalDateTime.now());
            block.syncBlockMethod1("스레드1");
            System.out.println("스레드1 종료 " + LocalDateTime.now());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("스레드2 시작 " + LocalDateTime.now());
            block.syncBlockMethod2("스레드2");
            System.out.println("스레드2 종료 " + LocalDateTime.now());
        });
        thread1.start();
        thread2.start();
    }

    private void syncBlockMethod1(String msg) {
        synchronized (o1) {
            System.out.println(msg + "의 syncBlockMethod1 실행중" + LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void syncBlockMethod2(String msg) {
        synchronized (o2) {
            System.out.println(msg + "의 syncBlockMethod2 실행중" + LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
