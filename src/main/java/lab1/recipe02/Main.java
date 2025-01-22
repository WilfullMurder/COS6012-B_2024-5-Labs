package lab1.recipe02;

public class Main {

    public static void main(String[] args){
        Thread task = new PrimeGenerator();
        task.start();

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        task.interrupt();

        System.out.println("Main: Status of the Thread: " + task.getState());
        System.out.println("Main: isInterrupted: " + task.isInterrupted());
        System.out.println("Main: isAlive: " + task.isAlive());
    }
}
