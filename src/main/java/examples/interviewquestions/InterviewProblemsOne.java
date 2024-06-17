package examples.interviewquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InterviewProblemsOne {

    public static void main(String[] args){

        System.out.println("\n----------------------\n");
        findMaxInteger();

        System.out.println("\n----------------------\n");
        toUpperCase();

        System.out.println("\n----------------------\n");
        filterForEvenNumbers();

        System.out.println("\n----------------------\n");
        findAverage();

    }

    public static void findMaxInteger(){
        List<Integer> numbers = Arrays.asList(2,5,8,4,9,3,6);

        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);

        System.out.println("Max number -> "+max.get());

    }

    public static void toUpperCase(){
        List<String> names = Arrays.asList("Hemnath","Kumar","Anil");

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        upperCaseNames.forEach(name -> System.out.println(name));
    }

    public static void filterForEvenNumbers(){
        List<Integer> numbers = Arrays.asList(3,5,4,2,6,7,8,9);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n%2 == 0)
                .collect(Collectors.toList());

        evenNumbers.forEach(System.out::println);
    }

    public static void findAverage(){
        List<Integer> numbers = Arrays.asList(2,4,5,6,7);

        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("Average -> "+average);
    }
}
