package lab2.recipe01.NotSynchronized;

public class Main {
    public static void main(String[] args){
        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);
        System.out.println("Parking Simulator");

        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numberSensors];
        for(int i = 0; i < numberSensors; i++){
            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }

        for(int i = 0; i < numberSensors; i++){
            try{
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("Number of cars: %d\n",
                stats.getNumberCars());
        System.out.printf("Number of motorcycles: %d\n",
                stats.getNumberMotorcycles());
        cash.close();
    }
}
