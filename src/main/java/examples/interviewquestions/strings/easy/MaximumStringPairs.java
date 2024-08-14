package examples.interviewquestions.strings.easy;

import java.util.HashSet;
import java.util.Set;

public class MaximumStringPairs {

    public static void main(String[] args) {
        String[] words = {"cd","ac","dc","ca","zz"};
        System.out.println("Count -> "+stringPairCount(words));
    }

    public static int stringPairCount(String[] words){
        Set<String> wordsSet = new HashSet<>();
        int count = 0;

        for (String word: words){
            String reversedWord = new StringBuilder(word).reverse().toString();
            if (wordsSet.contains(reversedWord)){
                count++;
                wordsSet.remove(reversedWord);
            }else {
                wordsSet.add(word);
            }
        }
        return count;
    }
}
