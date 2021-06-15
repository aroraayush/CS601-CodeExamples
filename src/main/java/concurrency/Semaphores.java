package concurrency;

import java.util.concurrent.*;

class Semaphores{

    private static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        // Not Re entrant
        // A semaphore (Mutex) is a variable or abstract data type used to control access to a common resource by multiple
        // processes and avoid critical section problems in a concurrent system such as a multitasking operating system.
        Semaphore semaphore = new Semaphore(2);
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++)
            es.submit(new Task(semaphore));
        es.shutdown();
        es.awaitTermination(1, TimeUnit.MINUTES);
    }


    static class Task implements Runnable {
        Semaphore semaphore;
        Task(Semaphore semaphore){
            this.semaphore = semaphore;
        }

        @Override
        public void run(){
            try{
                semaphore.acquireUninterruptibly();
                System.out.println(counter++ + " | " + Thread.currentThread().getId());
                semaphore.release();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}