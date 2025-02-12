package lab2.recipe04;

import java.util.Date;

public class Reader implements Runnable{
    private final PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo){
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++){
            System.out.printf("%s: %s: Price 1: %f\n",new Date(),
                    Thread.currentThread().getName(),
                    pricesInfo.getPrice1());
            System.out.printf("%s: %s: Price 2: %f\n",new Date(),
                    Thread.currentThread().getName(),
                    pricesInfo.getPrice2());
        }
    }
}
