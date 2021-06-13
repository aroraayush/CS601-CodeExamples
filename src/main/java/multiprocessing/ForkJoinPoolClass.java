package multiprocessing;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolClass {

    // it is a special thread pool designed to work with fork-and-join task splitting.
    static ForkJoinPool forkJoinPool;

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("The system has "+ cores + " cores");
        forkJoinPool  = new ForkJoinPool(cores); // cores

        int[] numbers = new int[1000];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        Long result = forkJoinPool.invoke(new Sum(numbers,0,numbers.length));
        System.out.println(result);

        // Sum left  = new Sum(numbers, 0, numbers.length);
        // left.fork();
    }

    //    RecursiveAction
    //    RecursiveAction represents a task which does not return any value.
    class Writer extends RecursiveAction {
        @Override
        protected void compute() {
            int i = 0;
            while (i < 5){
                System.out.println(i++);
            }
        }
    }

    //    RecursiveTask
    //    RecursiveTask represents a task which returns a value.
    static class Sum extends RecursiveTask<Long> {
        int low;
        int high;
        int[] array;

        Sum(int[] array, int low, int high) {
            this.array = array;
            this.low   = low;
            this.high  = high;
        }

        protected Long compute() {

            if(high - low <= 10) {
                long sum = 0;

                for(int i = low; i < high; ++i)
                    sum += array[i];
                return sum;
            } else {
                int mid = low + (high - low) / 2;
                Sum left  = new Sum(array, low, mid);
                Sum right = new Sum(array, mid, high);
                left.fork();
                long rightResult = right.compute();
                long leftResult  = left.join();
                return leftResult + rightResult;
            }
        }
    }
}
