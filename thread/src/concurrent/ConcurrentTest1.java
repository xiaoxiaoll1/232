package concurrent;

import java.util.concurrent.*;

public class ConcurrentTest1 implements Callable<Boolean> {

    private int Num=10;
    @Override
    public Boolean call() {
        while(true){
            if(Num<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->"+Num--);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConcurrentTest1 concurrentTest1 = new ConcurrentTest1();
        ConcurrentTest1 concurrentTest3 = new ConcurrentTest1();
        ConcurrentTest1 concurrentTest2 = new ConcurrentTest1();


//        new Thread(concurrentTest1,"xiao").start();
//        new Thread(concurrentTest1,"wang").start();
//        new Thread(concurrentTest1,"li").start();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> submit1 = executorService.submit(concurrentTest1);
        Future<Boolean> submit3 = executorService.submit(concurrentTest2);
        Future<Boolean> submit2 = executorService.submit(concurrentTest3);
        Boolean aBoolean = submit1.get();
        System.out.println(aBoolean);


    }
}
