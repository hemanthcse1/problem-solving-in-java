package examples.interviewquestions;

import java.util.Arrays;
import java.util.List;

public class FindLastString {

    public static void main(String[] args){

        List<String> names = Arrays.asList("Hemanth","Kumar","Rahul","Sharath","Anil","Kiran");

       String result =  names.stream()
                .skip(names.size() - 1)
                .findFirst()
                .get();

        System.out.println(result);
    }
}
