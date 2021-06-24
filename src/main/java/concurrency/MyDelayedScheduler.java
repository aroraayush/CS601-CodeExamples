package concurrency;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface DelayedScheduler {
    void delayedRun(long time, Runnable task);
}

public class MyDelayedScheduler implements DelayedScheduler {

    static Lock lock = new ReentrantLock();
    static Condition conditionMet = lock.newCondition();
    static Thread thread = new Thread();

    public static void main(String[] args) {
        System.out.println("Execution started...");
        MyDelayedScheduler scheduler = new MyDelayedScheduler();
        scheduler.delayedRun(2500, new Worker(1));
        scheduler.delayedRun(1500, new Worker(2));
    }

    static class Worker implements Runnable{
        int id;

        public Worker(int id) {
            this.id = id;
        }

        @Override
        public void run(){
            System.out.println("Task running "+ id);
        }
    }

    @Override
    public void delayedRun(long time, Runnable task){
        try{
            boolean isLocked = lock.tryLock();
            if(isLocked){  // spurious wakeups
//            thread
            conditionMet.await(time, TimeUnit.MILLISECONDS);
            task.run();

            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            // notify thread waiting for lock/monitor
//            conditionMet.signal();
            // conditionMet.signalAll(); // notify all threads
//            lock.unlock();
        }
    }
//    public boolean offer(Runnable x) {
//        if (x == null)
//            throw new NullPointerException();
//        RunnableScheduledFuture<?> e = (RunnableScheduledFuture<?>)x;
//        final ReentrantLock lock = this.lock;
//        lock.lock();
//        try {
//            int i = size;
//            if (i >= queue.length)
//                grow();
//            size = i + 1;
//            if (i == 0) {
//                queue[0] = e;
//                setIndex(e, 0);
//            } else {
//                siftUp(i, e);
//            }
//            if (queue[0] == e) {
//                leader = null;
//                available.signal();
//            }
//        } finally {
//            lock.unlock();
//        }
//        return true;
//    }
//
//    private void siftUp(int k, RunnableScheduledFuture<?> key) {
//        while (k > 0) {
//            int parent = (k - 1) >>> 1;
//            RunnableScheduledFuture<?> e = queue[parent];
//            if (key.compareTo(e) >= 0)
//                break;
//            queue[k] = e;
//            setIndex(e, k);
//            k = parent;
//        }
//        queue[k] = key;
//        setIndex(key, k);
//    }

//    RunnableScheduledFuture<V>
}
