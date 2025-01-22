package lab1.example2;

public class RunMethodExample implements Runnable {

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
        Thread th1 = new Thread(new RunMethodExample(), "thread_1");
        Thread th2 = new Thread(new RunMethodExample(), "thread_2");
        // Common pitfall: Calling run() instead of start()
        th1.run();
        th2.run();
    }
}