package lab1.recipe04;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ConsoleClock implements Runnable{
    private final static int MAX_ITERATIONS = 10;
    @Override
    public void run() {
        for(int i = 0; i < MAX_ITERATIONS; i++){
            System.out.printf("%s\n", new Date());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                System.out.println("The ConsoleClock has been interrupted");
            }
        }
    }
}
