package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceCron {

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
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        final ScheduledFuture<?> beeperHandle =
                scheduledExecutorService.scheduleAtFixedRate(new Worker(5), 2, 3, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(() -> { beeperHandle.cancel(true); },
                60 * 60, TimeUnit.SECONDS);
    }
}
