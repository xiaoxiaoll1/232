package concurrent;

public class TestSleep implements Runnable {
    @Override
    public void run() {
        Thread.yield();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
