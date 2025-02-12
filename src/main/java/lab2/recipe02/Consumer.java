package lab2.recipe02;

public class Consumer implements Runnable{
    private final EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            storage.get();
        }
    }
}
