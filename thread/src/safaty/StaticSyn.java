package safaty;

public class StaticSyn {

    public static synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("1");
    }
    public static synchronized void b(){
        System.out.println("2");
    }

    public static void main(String[] args) {
        StaticSyn staticSyn = new StaticSyn();
        new Thread(()->{
            try {
                staticSyn.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                staticSyn.b();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
