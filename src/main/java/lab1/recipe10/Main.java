package lab1.recipe10;

public class Main {
    public static void main(String[] args){
        MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();

        Thread thread;
        System.out.print("Starting the Threads\n");
        for(int i = 0; i < 10; i++){
            thread = threadFactory.newThread(task);
            thread.start();
        }
        System.out.print("Factory stats:\n");
        System.out.printf("%s\n",threadFactory.getStats());
    }
}
