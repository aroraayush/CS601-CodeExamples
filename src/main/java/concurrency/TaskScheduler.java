package concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskScheduler {

    static class Task implements Runnable {
        int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("Running task : " + i);
        }
    }

    private static class TaskTime implements Comparable<TaskTime> {
        public long timestampMilis;
        public Task task;

        TaskTime(long timestamp, Task task) {
            this.task = task;
            this.timestampMilis = timestamp;
        }

        @Override
        public int compareTo(TaskTime task) {
            // sorting based on Ts
            long diff = timestampMilis - task.timestampMilis;
            if (diff > 0) return 1;
            return diff == 0 ? 0 : -1;
        }
    }

    public static class TimerQueue {

        private final PriorityBlockingQueue<TaskTime> queue = new PriorityBlockingQueue<>();

        public void addTask(long timestampMillis, Task task) {
            queue.add(new TaskTime(timestampMillis, task));
        }

        public long getSonnestTimestampMillis() {
            TaskTime taskTime = queue.peek();
            if (taskTime == null) return 0;
            return taskTime.timestampMilis;
        }

        private Task popSoonestTask() {
            TaskTime taskTime = queue.poll();
            if (taskTime == null) return null;
            return taskTime.task;
        }
    }

    public static class TaskTimerRunnable implements Runnable {
        private static final int MAX_THREADS = 1;
        private TimerQueue queue;
        private ExecutorService pool = Executors.newFixedThreadPool(MAX_THREADS);
        private Thread timerThread;

        public TaskTimerRunnable() {
            this.queue = new TimerQueue();
        }

        @Override
        public void run() {
            timerThread = Thread.currentThread();
            while (true) {
                long soonestTimestampMillis = queue.getSonnestTimestampMillis();
                long currentTimestampMillis = System.currentTimeMillis();
                if (soonestTimestampMillis <= currentTimestampMillis) {
                    Task task = queue.popSoonestTask();
                    if(task != null)
                        pool.submit(task);
                } else {
                    sleep(soonestTimestampMillis - currentTimestampMillis);
                }
            }
        }

        private void sleep(long millis) {
            try {
                if (millis <= 0) {
                    Thread.sleep(Long.MAX_VALUE);
                } else {
                    Thread.sleep(millis);
                }
            } catch (InterruptedException e) {
                return;
            }
        }

        public void addTask(long whenTimestampMillis, Task task) {

            queue.addTask(whenTimestampMillis, task);
            long soonestTimestampMillis = queue.getSonnestTimestampMillis();
            if (whenTimestampMillis >= soonestTimestampMillis) {
                // interrupt timer thread
                if (timerThread != null) {
                    timerThread.interrupt();
                }
            }
        }
    }

    public static class TestTask implements Runnable {
        private long timestampMillis;

        public TestTask(long timestampMillis) {
            this.timestampMillis = timestampMillis;
        }

        @Override
        public void run() {
            System.out.println("Timestamp: " + timestampMillis);
        }
    }

    public static void main(String[] args) {
        TaskTimerRunnable timer = new TaskTimerRunnable();
        Thread timerThread = new Thread(timer);

        long currentTimestamp = System.currentTimeMillis();
        timer.addTask(currentTimestamp + 3000, new Task(3));
        timer.addTask(currentTimestamp + 2000, new Task(2));
        timer.addTask(currentTimestamp + 1000, new Task(1));
//        for (int i = 0; i < 20; i++) {
//            long whenMillis = currentTimestamp + 5000 + i * 1000;
//            timer.addTask(whenMillis, new TestTask(whenMillis));
//        }
        timerThread.start();

//        try {
//            timerThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
