package lab1.recipe10;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
    @Override
    public void run() {
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
