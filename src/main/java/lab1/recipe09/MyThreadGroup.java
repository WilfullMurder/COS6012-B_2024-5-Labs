package lab1.recipe09;

public class MyThreadGroup extends ThreadGroup{


    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e){
        System.out.printf("The thread %s has thrown an Exception\n",
                t.getId());
        e.printStackTrace(System.out);
        System.out.print("Terminating the rest of the Threads\n");
        interrupt();
    }
}
