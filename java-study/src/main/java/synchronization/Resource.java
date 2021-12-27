package synchronization;

import java.util.concurrent.Semaphore;

public class Resource {

    private final Semaphore semaphore;
    private final int maxThread;

    public Resource(int maxThread) {
        this.maxThread = maxThread;
        this.semaphore = new Semaphore(maxThread);
    }

    public void use() {
        try {
            semaphore.acquire();
            System.out.println("[" + Thread.currentThread().getName() + "]" + (maxThread - semaphore.availablePermits())
                + "개의 스레드가 점유중");
            Thread.sleep(1000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
