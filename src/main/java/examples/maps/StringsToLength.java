package examples.maps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringsToLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<Integer> lengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(lengths);
    }
}
