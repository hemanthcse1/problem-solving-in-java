package examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupingExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ananya", "Bhanu", "Ajay", "Kiran", "Arun");

        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));

        groupedByLength.forEach((length, namesList) -> {
            System.out.println("Length: " + length);
            namesList.forEach(System.out::println);
        });
    }
}
