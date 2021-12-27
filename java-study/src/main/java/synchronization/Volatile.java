package synchronization;

public class Volatile {

    private static boolean stopRequested;

    /*
    volatile 붙인 경우
    프로그램이 정상 종료됨

    volatile 붙이지 않은 경우
    무한 루프에 빠짐
    */

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();

        Thread.sleep(1000);
        stopRequested = true;
    }
}
