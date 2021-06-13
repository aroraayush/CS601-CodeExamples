package junit;

public class Fibonacci {
    public static int compute(int n) {

        int[] arr = new int[n+1];
        arr[0] = 0;
        if (n > 0)
            arr[1] = 1;
        for (int k = 2; k <= n; k++) {
            arr[k] = arr[k-1] + arr[k-2];
        }
        return arr[n];
    }
}
