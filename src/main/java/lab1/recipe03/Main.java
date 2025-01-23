package lab1.recipe03;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        FileSearch searcher = new FileSearch("C:\\Windows", "explorer.exe");
        Thread thread = new Thread(searcher);
        thread.start();

        try{
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
