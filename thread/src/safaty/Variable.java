package safaty;

import java.util.ArrayList;

public class Variable {

    public static void main(String[] args) {
        Part part = new Part();
        UnsafeSubPart unsafeSubPart = new UnsafeSubPart();
        new Thread(()->{
            unsafeSubPart.method1();
        }).start();
        new Thread(()->{
            unsafeSubPart.method1();
        }).start();
    }
}

class Part{
    public void method1(){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            method2(integers);
            method3(integers);
        }
    }
    public void method2(ArrayList<Integer> list){
        list.add(1);
    }
    public void method3(ArrayList<Integer> list){
        list.remove(0);
    }
}
class UnsafeSubPart extends Part{
    @Override
    public void method3(ArrayList<Integer> list) {
        new Thread(()->{
            list.remove(0);
        }).start();
    }
}