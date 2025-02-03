package lab2.recipe01.Synchronized;

public class ParkingStats {
    private final Object controlCars, controlMotorcycles;
    private long numberCars = 0L;
    private long numberMotorcycles = 0L;
    private final ParkingCash cash;

    public ParkingStats(ParkingCash cash){
        this.cash = cash;
        controlCars = new Object();
        controlMotorcycles = new Object();
    }

    public void carComeIn(){
        synchronized (controlCars){
            numberCars++;
        }
    }

    public void carGoOut(){
        synchronized (controlCars){
            numberCars--;
        }
        cash.vehiclePay();
    }

    public void motoComeIn(){
        synchronized (controlMotorcycles){
            numberMotorcycles++;
        }
    }

    public void motoGoOut(){
        synchronized (controlMotorcycles){
            numberMotorcycles--;
        }
        cash.vehiclePay();
    }

    public long getNumberCars() {
        return numberCars;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }
}
