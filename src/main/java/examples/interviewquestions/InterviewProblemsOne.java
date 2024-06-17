package examples.interviewquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InterviewProblemsOne {

    public static void main(String[] args){

        findMaxInteger();

    }

    public static void findMaxInteger(){
        List<Integer> numbers = Arrays.asList(2,5,8,4,9,3,6);

        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);

        System.out.println("Max number -> "+max.get());

    }
}
