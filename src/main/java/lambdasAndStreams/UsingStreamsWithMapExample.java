package lambdasAndStreams;

import java.util.HashMap;
import java.util.Map;

/** A simple example demonstrating using streams */
public class UsingStreamsWithMapExample {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "English");
        map.put("hola", "Spanish");
        map.put("namaste", "Hindi");
        map.put("ni hao", "Mandarin");
        map.put("privet", "Russian");

        map.entrySet().stream().filter(s -> s.getValue().startsWith("E")).forEach(s -> System.out.println(s));

    }
}
