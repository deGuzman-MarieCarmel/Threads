package sampleThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// This program creates a thread pool using Executor interface that uses atomic counter variable

// AtomicCounter class that implements methods to increment and get value
class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);
    public int incrementAndGet() {
        return count.incrementAndGet();
    }
    public int getCount() {
        return count.get();
    }
}

public class fixedExecutorThread {

    public static void main(String[] args) throws InterruptedException {

       // Creates a fixed size thread pool of 10 worker threads which will hold the runnables
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Create an instance of the atomicCounter and prints its initial value.
        AtomicCounter atomicCounter = new AtomicCounter();
        System.out.println("\n\nInitializing all threads. Initial count is " + atomicCounter.getCount());

        // Submits 100 jobs to our pool of multiple threads
        workerThread[] threads = new workerThread[100];
        for (int i = 0; i < 100; i++) {
            atomicCounter.incrementAndGet();
            threads[i] = new workerThread("Marie", atomicCounter.getCount());
            threads[i].start();
        }
        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        // Terminates executor
        executor.shutdown();

        //while (!executor.isTerminated()) {
        //}
        System.out.println("\n\nFinished all threads. Final count is " + atomicCounter.getCount());
    }

}
