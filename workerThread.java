package sampleThreadPool;

// This class creates the worker thread that implements Runnable

public class workerThread extends Thread implements Runnable {

    // DECLARATIONS
    private String task;
    private int count;

    // CONSTRUCTORS
    public workerThread(String task, int count){
        this.task=task;
        this.count=count;
    }

    // RUNNABLE method that specifies tasks that need to be performed concurrently
    @Override
    public void run() {
        System.out.println("\n\nTask " + task + " " + count + " starts.");
        processSleep();
    }

    // Puts the THREAD to sleep for 1 second to simulate long running task
    private void processSleep() {
        System.out.println("\nTask " + task + " " + count + " sleeps.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
