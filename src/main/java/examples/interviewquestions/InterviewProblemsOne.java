package examples.interviewquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InterviewProblemsOne {

    public static void main(String[] args){

        findMaxInteger();

        toUpperCase();

        filterForEvenNumbers();

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
}
