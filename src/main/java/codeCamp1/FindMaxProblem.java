package codeCamp1;

public class FindMaxProblem { // non-parameterized class has a parameterized method
    public <T extends Comparable> T findMax(T[] array) {
        T maxValue = array[0];
        for (int i = 1 ;i < array.length; i++) {
            if (maxValue.compareTo(array[i]) < 0) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        String[] arr = {"d", "b", "a", "z", "t"};
        FindMaxProblem parametrizedMethodEx = new FindMaxProblem();
        System.out.println(parametrizedMethodEx.findMax(arr));

        Integer[] arrInt = {10, 0, 4, -50, 40, -20};
        FindMaxProblem parametrizedMethodExInt = new FindMaxProblem();
        System.out.println(parametrizedMethodExInt.findMax(arrInt));
    }
}
