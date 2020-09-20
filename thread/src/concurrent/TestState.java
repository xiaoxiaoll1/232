package concurrent;

public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread.State state = thread.getState();
        System.out.println(state);
        thread.start();
        state = thread.getState();
        System.out.println(state);
        while (state!=Thread.State.TERMINATED){
            Thread.sleep(200);
            state=thread.getState();
            System.out.println(state);
        }

       // thread.start();
    }
}
