package examples.interviewquestions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args){

        List<Integer> duplicateList = Arrays.asList(2,4,5,7,4,6,4,6,7,8,9,8);


        List<Integer> result = duplicateList.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
