package concurrent;

public class RabbitAndTurtle implements Runnable {

    private static String winner;
    @Override
    public void run() {

        for (int i = 0; i <=100 ; i++) {
            boolean flag;
            if((flag=isWin(i))==true){
                break;
            }

            System.out.println(Thread.currentThread().getName()+"-->"+i);
            if(Thread.currentThread().getName().equals("兔子")&&(i%20==0)){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public boolean isWin(int steps){
        if(winner!=null){
            System.out.println("winner is"+winner);
            return true;
        }
        else if(steps>=100){
            winner=Thread.currentThread().getName();
            System.out.println("winner is"+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RabbitAndTurtle rabbitAndTurtle = new RabbitAndTurtle();
        new Thread(rabbitAndTurtle,"兔子").start();
        new Thread(rabbitAndTurtle,"乌龟").start();

    }
}
