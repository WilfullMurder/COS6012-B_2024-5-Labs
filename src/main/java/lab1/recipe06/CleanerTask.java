package lab1.recipe06;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread{
    private final Deque<Event> deque;

    public CleanerTask(Deque<Event> deque){
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run(){
        while (true){
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;

        if (deque.size() == 0){
            return;
        }

        delete = false;
        do{
            Event e = deque.getLast();
            difference = date.getTime() - e.getDate().getTime();
            if (difference > 10000){
                System.out.printf("Cleaner: %s\n", e.getEvent());
                deque.removeLast();
                delete = true;
            }
        }while(difference > 10000);
        if(delete){
            System.out.printf("Cleaner: Size of the queue: %d\n", deque.size());
        }
    }
}
