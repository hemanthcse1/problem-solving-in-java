package examples.maps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerToSquare {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
        System.out.println(squares);
    }
}
