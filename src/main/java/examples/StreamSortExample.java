package examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ananya", "Bhanu", "Ajay", "Kiran", "Arun");

        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());

        sortedNames.forEach(System.out::println);
    }
}
