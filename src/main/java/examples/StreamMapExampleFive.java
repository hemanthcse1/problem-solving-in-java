package examples;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamMapExampleFive {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Orange");
        map.put(1, "Apple");
        map.put(2, "Banana");

        Map<Integer, String> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        TreeMap::new));

        sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
