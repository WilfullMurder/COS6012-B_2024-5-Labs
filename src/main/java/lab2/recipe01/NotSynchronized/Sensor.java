package lab2.recipe01.NotSynchronized;

import java.util.concurrent.TimeUnit;

public class Sensor implements Runnable{
    private final ParkingStats stats;

    public Sensor(ParkingStats stats){
        this.stats = stats;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            stats.carComeIn();
            stats.carComeIn();
            try{
                TimeUnit.MILLISECONDS.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            stats.motoComeIn();
            try{
                TimeUnit.MILLISECONDS.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            stats.motoGoOut();
            stats.carGoOut();
            stats.carGoOut();
        }
    }
}
