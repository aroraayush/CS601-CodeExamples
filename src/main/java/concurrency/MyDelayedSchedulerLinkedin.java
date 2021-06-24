package concurrency;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//public interface DelayedScheduler {
//    void delayedRun(long epochTimeToRun, Runnable task);
//}
//public interface Runnable {
//    public void run();
//}

/*
# void  await()
Causes the current thread to wait until it is signalled or interrupted.

# boolean  await(long time, TimeUnit unit)
Causes the current thread to wait until it is signalled or interrupted, or the specified waiting time elapses.

# long  awaitNanos(long nanosTimeout)
Causes the current thread to wait until it is signalled or interrupted, or the specified waiting time elapses.

# void  awaitUninterruptibly()
Causes the current thread to wait until it is signalled.

# boolean  awaitUntil(Date deadline)
Causes the current thread to wait until it is signalled or interrupted, or the specified deadline elapses.

# void  signal()
Wakes up one waiting thread.

# void  signalAll()
Wakes up all waiting threads.

Condition condition  = lock.newCondition();
*/

// await(long time, TimeUnit unit)
// signalAll()

public class MyDelayedSchedulerLinkedin {

    static class MyDelayedScheduler2 implements DelayedScheduler {

        PriorityBlockingQueue<TaskWihTs> pQueue;
        Lock lock = new ReentrantLock();
        Condition condition  = lock.newCondition();
        long startingTime;
        // implement here
        public MyDelayedScheduler2(long startingTime){
            this.pQueue = new PriorityBlockingQueue<>();
            this.startingTime = startingTime;
            // this.lock = lock;
        }
        /*
          scheduler.delayedRun(1000, task1);
          scheduler.delayedRun(99, task2);
        */
        @Override
        public void delayedRun(long timeToRun, Runnable task){
            // will give an epoch time
            pQueue.add(new TaskWihTs(startingTime + timeToRun, task));
            while (true){
                long currTime = System.currentTimeMillis();
                if(pQueue.peek() != null && currTime > pQueue.peek().getTs()){
                    Thread thread = new Thread(pQueue.poll().getTask());
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }



//    void runTask(){
////        synchronized(this){
//        TaskWihTs taskWithTs = pQueue.poll();
//        Runnable task  = taskWithTs.getTask();
//        try{
//            condition.await(epochTimeToRun, TimeUnit.MILLISECONDS)
//            // Thread.sleep(epochTimeToRun, TimeUnit.MILLISECONDS);
//            // lock.tryLock();
//            task.start();
//        }
//        catch(InterruptedException e){
//
//        }
//        finally{
//            condition.signal()
//        }
////        }
//    }
    }

    static class TaskWihTs implements Comparable<TaskWihTs>{

        private long ts;
        private Runnable task;

        public long getTs() {
            return ts;
        }

        TaskWihTs(long ts, Runnable task){
            this.ts = ts;
            this.task = task;

//        try{
//            Thread.sleep(ts);
//        }
//        catch(InterruptedException e){
//
//        }
//        finally{
//            this.task.start();
//        }
        }

        public Runnable getTask() {
            return task;
        }

        @Override
        public int compareTo(TaskWihTs o) {
            return 0;
        }
    }

    static class Task implements Runnable{
        int i;
        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run(){
            System.out.println("Task running : "+ i + " | " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        // init
         long startingTime = System.currentTimeMillis();
        MyDelayedScheduler2 scheduler = new MyDelayedScheduler2(startingTime);
        scheduler.delayedRun(10000, new Task(1));
        scheduler.delayedRun(2000, new Task(1));
//        scheduler.delayedRun(99, new Task(2));
//        scheduler.delayedRun(0, new Task(3));
    }
}

/*
1. priority queue for time sorting
2. threads sleep
*/