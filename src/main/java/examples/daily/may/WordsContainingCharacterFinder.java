package examples.daily.may;

import java.util.ArrayList;
import java.util.List;

public class WordsContainingCharacterFinder {

    public static void main(String[] args) {
        WordsContainingCharacterFinder solution = new WordsContainingCharacterFinder();

        String[] words = {"banana", "apple", "cherry", "dates", "mango"};
        char x = 'a';

        List<Integer> resultIndices = solution.findWordsContaining(words, x);

        System.out.println("Indices of words containing '" + x + "': " + resultIndices);
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i< words.length; i++){
            if (words[i].indexOf(x) != -1){
                indices.add(i);
            }
        }
        return indices;
    }
}
