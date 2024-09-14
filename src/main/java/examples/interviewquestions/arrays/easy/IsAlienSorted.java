package examples.interviewquestions.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class IsAlienSorted {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSorted(String word1, String word2, Map<Character, Integer> orderMap) {
        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++) {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);
            if (char1 != char2) {
                return orderMap.get(char1) < orderMap.get(char2);
            }
        }
        return word1.length() <= word2.length();
    }

    public static void main(String[] args) {
        IsAlienSorted solution = new IsAlienSorted();

        String[] words1 = {"hello", "leetcode"};
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(solution.isAlienSorted(words1, order1));


        String[] words2 = {"word", "world", "row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";
        System.out.println(solution.isAlienSorted(words2, order2));

        String[] words3 = {"apple", "app"};
        String order3 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(solution.isAlienSorted(words3, order3));
    }
}
