package concurrent;

public class RunN implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("laile"+i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunN());
        thread.start();
        Thread thread2 = new Thread(new RunN());
        thread2.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("woshi"+i);
        }
    }
}
