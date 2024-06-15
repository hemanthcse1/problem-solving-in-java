package examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMapExampleFour {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Orange");

        List<Integer> keys = map.keySet().stream().collect(Collectors.toList());
        List<String> values = map.values().stream().collect(Collectors.toList());

        System.out.println("Keys: " + keys);
        System.out.println("Values: " + values);
    }
}
