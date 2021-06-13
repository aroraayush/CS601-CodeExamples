package lambdasAndStreams;

import java.util.*;

public class SimpleLambdaExample {
    public static void main(String[] args) {

        String[] words = {"hello", "bye", "greeting"};
        Arrays.sort(words, (s1, s2)-> s1.compareTo(s2));
        System.out.println(Arrays.toString(words));

    }
}
