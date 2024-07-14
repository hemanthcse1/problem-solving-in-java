package examples.interviewquestions.strings;

import java.util.ArrayList;
import java.util.List;

public class WordsContainsCharacter {

    public static void main(String[] args) {
        String[] words = {"leet", "code"};
        char x = 'e';
        System.out.println("Result : "+ wordsContainsCharacter(words,x));
    }

    public static List<Integer> wordsContainsCharacter(String[] words, char x){
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i< words.length; i++){
            if (words[i].indexOf(x) != -1){
                indices.add(i);
            }
        }

        return indices;
    }
}
