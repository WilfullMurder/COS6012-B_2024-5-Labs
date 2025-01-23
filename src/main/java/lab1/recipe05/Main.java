package lab1.recipe05;

public class Main {
    public static void main(String[] args){
       DataSourceLoader dataSourceLoader = new DataSourceLoader();
       Thread dataSourceThread = new Thread(dataSourceLoader, "DataSourceThread");

       NetworkConnectionsLoader networkConnectionsLoader = new NetworkConnectionsLoader();
       Thread networkConnectionsThread = new Thread(networkConnectionsLoader, "NetworkConnectionsThread");

       dataSourceThread.start();
         networkConnectionsThread.start();

         try{
            dataSourceThread.join();
            networkConnectionsThread.join();
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
    }
}
