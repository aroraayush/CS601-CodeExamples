package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceClass {

    static class Worker implements Runnable{
        int i;

        public Worker(int i) {
            this.i = i;
        }

        @Override
        public void run(){
            System.out.println("Task started for  "+ i + " ...");
            System.out.println("Task completed !!");
        }
    }
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(new Worker(1),5, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new Worker(2),3, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new Worker(3),1, TimeUnit.SECONDS);

    }
}
