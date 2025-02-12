package lab2.recipe03;

public class Main {
    public static void main(String[] args){
        System.out.print("Running example with fair-mode = false\n");
        testPrintQueue(false);
        System.out.print("Running example with fair-mode = true\n");
        testPrintQueue(true);
    }

    private static void testPrintQueue(boolean fairMode){
        PrintQueue printQueue = new PrintQueue(fairMode);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread " + i);
        }
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
