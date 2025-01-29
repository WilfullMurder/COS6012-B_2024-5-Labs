package lab1.recipe06;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Deque<Event> deque = new ConcurrentLinkedDeque<>();

        WriterTask writer = new WriterTask(deque);

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            executorService.submit(writer);
        }

        CleanerTask cleaner = new CleanerTask(deque);
        executorService.submit(cleaner);

        executorService.shutdown();
    }
}