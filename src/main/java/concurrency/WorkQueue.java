package concurrency;

import java.util.LinkedList;

/**
 * This class is essentially  a partial implementation of ExecutorService.
 */
public class WorkQueue {

    private final LinkedList<Runnable> queue;
    private final int nThreads;

    // Array of class PoolWorker
    private final PoolWorker[] threads;

    private class PoolWorker extends Thread {
        public void run() {
            Runnable runnable;

            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }

                    runnable = queue.removeFirst();
                }

                // If we don't catch RuntimeException,
                // the pool could leak threads
                try {
                    runnable.run();
                } catch (RuntimeException e) {
                    // You might want to log something here
                    System.out.println(e);
                }
            }
        }
    }

    public WorkQueue(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedList<>();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable r) {
        synchronized (queue) {
            queue.addLast(r);
            queue.notify();
        }
    }

    public static void main(String[] args) {
        WorkQueue queue = new WorkQueue(2);
        queue.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(1+2);
            }
        });
        queue.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(1+2);
            }
        });
    }
}