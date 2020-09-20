package safaty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Ticket {
    static Random random = new Random();
    public static void main(String[] args) throws InterruptedException {

        TicketWindow ticketWindow = new TicketWindow(12000);
        ArrayList<Thread> threads = new ArrayList<>();
        List<Integer> integers = new Vector<>();
        for (int i = 0; i < 4000; i++) {
            Thread thread = new Thread(()->{
                int sell = ticketWindow.sell(randomNum());
                integers.add(sell);
                try {
                    Thread.sleep(randomNum());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads.add(thread);
            thread.start();

        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(ticketWindow.getCount());
        System.out.println(integers.stream().mapToInt((i)->i).sum());

    }
    public static int randomNum(){
        return random.nextInt(5)+1;
    }
}

class TicketWindow{
    private int count=0;

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount(){
        return count;
    }
    public synchronized int sell(int amount){
        if(amount<=count){
            count-=amount;
            return amount;
        }else {
            return 0;
        }
    }
}