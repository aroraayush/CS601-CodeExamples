package concurrency;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**  Based on NoSynchronization example. Uses AtomicInteger */
public class WithAtomicInteger {

    // Atomicity preserved
    private AtomicInteger x = new AtomicInteger(0);

    private class AdditionTask implements Runnable {
        public void run() {

            for (int i = 0; i < 1000; i++) {
                    x.incrementAndGet();
            }
        }

    }

    private class SubtractionTask implements Runnable {
        public void run() {
            for (int i = 0; i < 1000; i++) {
                x.decrementAndGet();
            }
        }
    }

    public void createThreads() throws InterruptedException {
        Thread t1 = new Thread(new AdditionTask());
        Thread t2 = new Thread(new SubtractionTask());
        t1.start();
        t2.start();
        // wait for threads 1 and 2 to  finish
        t1.join();
        t2.join();

        // Note: we are reading x below, but no need to synchronize here since t1 and t2 finished
        if (x.get() != 0) // will only print something if x i not 0
            System.out.print(x + " ");
        // System.out.println("Done");
    }

    public static void main(String[] args)  {
        WithAtomicInteger ns = new WithAtomicInteger();
        try {
            //for (int i = 0; i < 10000; i++) {
            ns.createThreads();
            //}
        }
        catch  (InterruptedException e) {
            System.out.println("Thread got interrupted: " + e);
        }
        //System.out.println("Done");

    }

}

