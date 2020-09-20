package safaty;

public class Syn {

    static int count = 0;
    static Object lock = new Object();


    public static void main(String[] args) {
        Room room = new Room();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.increment();
            }
        },"t1");
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                  room.decrement();
                }
            }
        },"t2");
        thread1.start();
        thread2.start();
        System.out.println(room.getCounter());
    }
}

class Room{
    private int counter=0;

    public void increment(){
        synchronized (this){
            counter++;
        }
    }
    public void decrement(){
        synchronized (this){
            counter--;
        }
    }
    public int getCounter(){
        synchronized (this){
            return counter;
        }
    }
}