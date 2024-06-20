package examples.interviewquestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseStringUsingStream {

    public static void main(String[] args){

        String sentence = "Hello world welcome to Java";

        String[] words = sentence.split(" ");

        List<String> result = Arrays.stream(words)
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.toList());

        System.out.println(result);


    }
}
