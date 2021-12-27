package synchronization;

public class Semaphore {

    public static void main(String[] args) {
        Resource resource = new Resource(3);
        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(resource::use);
            t.start();
        }
    }
}
