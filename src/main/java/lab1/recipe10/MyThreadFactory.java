package lab1.recipe10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private final String name;
    private final List<String> stats;

    public MyThreadFactory(String name){
        this.name = name;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s\n",
                t.getId(), t.getName(), new Date()));
        return t;
    }

    public String getStats() {
        StringBuilder builder = new StringBuilder();

        for (String stat : stats) {
            builder.append(stat);
            builder.append("\n");
        }
        return builder.toString();
    }
}
