package lab2.recipe01.NotSynchronized;

public class ParkingStats {
    private long numberCars = 0L;
    private long numberMotorcycles = 0L;
    private final ParkingCash cash;

    public ParkingStats(ParkingCash cash){
        this.cash = cash;
    }

    public void carComeIn(){
        numberCars++;
    }

    public void carGoOut(){
        numberCars--;
        cash.vehiclePay();
    }

    public void motoComeIn(){
        numberMotorcycles++;
    }

    public void motoGoOut(){
        numberMotorcycles--;
        cash.vehiclePay();
    }

    public long getNumberCars() {
        return numberCars;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }
}
