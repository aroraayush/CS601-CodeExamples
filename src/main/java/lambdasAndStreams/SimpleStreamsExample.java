package lambdasAndStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** A simple example demonstrating using streams */
public class SimpleStreamsExample {
    public static void main(String[] args) {
        String[] myStringArray = {"hello", "hola", "privet", "namaste", "ni hao"};
        List<String> myStrings = Arrays.asList(myStringArray);

        myStrings.forEach(s-> System.out.println(s + ";"));
        // can also do:
        // myStrings.stream().forEach((s)-> System.out.println(s));
        //myStrings.stream().forEach(System.out::println); // using Method Reference
        System.out.println();

        // Another syntax
        Stream<String> stream = Stream.of("hello", "hola", "privet", "namaste", "ni hao");
        stream.forEach((s)-> System.out.println(s));
        //stream.forEach(System.out::println); // using  Method reference
        System.out.println();

        // Using filter function
        Stream<String> stream2 = Stream.of("hello", "hola", "privet", "namaste", "ni hao");
        stream2.filter(s -> s.contains("h")).forEach(s-> System.out.println(s));

        System.out.println(System.lineSeparator() + "After filtering by length: ");
        Stream<String> stream3 = Stream.of("hello", "hola", "privet", "namaste", "ni hao");
        List<String> result = stream3.filter(word -> word.length() > 5).filter(s -> s.startsWith("n"))
                .collect(Collectors.toList());
        result.stream().forEach(s -> System.out.println(s));
    }
}
