package lab1.recipe03;

import java.io.File;

public class FileSearch implements Runnable{
    private final String initPath;
    private final String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }


    @Override
    public void run() {
        File file = new File(initPath);
        if(file.isDirectory()){
            try{
                directoryProcess(file);
            }catch (InterruptedException e){
                System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
            }
        }
    }


    private void directoryProcess(File file) throws InterruptedException {
        File[] list = file.listFiles();
        if(list != null){
            for (File currentFile : list) {
                if (currentFile.isDirectory()) {
                    directoryProcess(currentFile);
                } else {
                    fileProcess(currentFile);
                }
            }
        }

        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if(file.getName().equals(fileName)){
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }

        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }
}
