package concurrent;

public class TestPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        TestPriority testPriority = new TestPriority();
        Thread a = new Thread(testPriority, "a");
        Thread b = new Thread(testPriority, "b");
        Thread c= new Thread(testPriority, "c");
        Thread d = new Thread(testPriority, "d");
        b.setPriority(8);
        b.start();
        c.setPriority(Thread.MAX_PRIORITY);
        c.start();
        d.setPriority(3);
        d.start();
        a.start();
    }
}
