package examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ananya", "Bhanu", "Ajay", "Kiran", "Arun");

        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        filteredNames.forEach(System.out::println);
    }
}
