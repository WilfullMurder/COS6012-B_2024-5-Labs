package lab1.recipe08;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        UnsafeTask unsafeTask=new UnsafeTask();
        for (int i=0; i<3; i++){
            Thread thread=new Thread(unsafeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Unsafe task has ended... Starting safe task");
        SafeTask safeTask = new SafeTask();
        for (int i=0; i<3; i++){
            Thread thread=new Thread(safeTask);

            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}