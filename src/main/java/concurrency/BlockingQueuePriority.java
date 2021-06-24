package concurrency;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueuePriority {


    static PriorityBlockingQueue<WorkerWithTs> pQueue = new PriorityBlockingQueue<>();

    static class Worker implements Runnable{

        private int id;

        public Worker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Task running for id : " + id);
        }
    }

    static class WorkerWithTs implements Comparable<WorkerWithTs>{
        Worker w;
        int ts;
        public WorkerWithTs(Worker w, int ts) {
            this.w = w;
            this.ts = ts;
        }

        @Override
        public int compareTo(WorkerWithTs o) {
            if(this.ts < o.ts)
                return -1;
            else if(this.ts > o.ts)
                return 1;
            return 0;
        }
    }
    public static void main(String[] args) {
        pQueue.add(new WorkerWithTs(new Worker(1),100));
        pQueue.add(new WorkerWithTs(new Worker(2),10));
        pQueue.add(new WorkerWithTs(new Worker(3),50));

        while (!pQueue.isEmpty()){
            System.out.println(pQueue.poll().ts);
        }
    }
}
