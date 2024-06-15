package examples;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMapExampleTwo {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Orange");
        map.put(4, "Mango");

        Map<Integer, String> filteredMap = map.entrySet().stream()
                .filter(entry -> entry.getKey() % 2 == 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        filteredMap.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
