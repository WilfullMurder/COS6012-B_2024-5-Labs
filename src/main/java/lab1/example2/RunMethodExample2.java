package lab1.example2;

public class RunMethodExample2 implements Runnable {

    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is printing " + i);
        }
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new RunMethodExample2(), "thread_1");
        Thread th2 = new Thread(new RunMethodExample2(), "thread_2");

        // When calling a start() method, then a new separate thread is being 
        // allocated to the execution of run method.  
        th1.start();
        th2.start();

        // Common pitfall: Calling run() instead of start()
        // th1.run();
        // th2.run();
    }
}
