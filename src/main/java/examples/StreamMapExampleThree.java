package examples;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMapExampleThree {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Orange");

        Map<Integer, String> transformedMap = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().toUpperCase()));

        transformedMap.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
