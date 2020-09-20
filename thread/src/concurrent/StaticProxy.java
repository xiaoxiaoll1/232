package concurrent;

public class StaticProxy {

    public static void main(String[] args) {
        Thread wolaile = new Thread(() -> System.out.println("wolaile"));
        wolaile.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("wolaile");
            }
        }).start();

        Thread thread = new Thread(()->{
            System.out.println("sdioo");
        });
    }

}
