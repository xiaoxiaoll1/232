package concurrent;

public class TestDaemon {
    public static void main(String[] args) {
        You you = new You();
        God god = new God();
        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();
        Thread thread1 = new Thread(you);
        thread1.start();
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("god is looking at you");
        }
    }
}
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 30000; i++) {
            System.out.println("happy");
        }
        System.out.println("die");
    }
}
