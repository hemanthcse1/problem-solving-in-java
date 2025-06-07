package examples.daily.june;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class LexicographicallyMinimumAfterRemovingStars {

    public String clearStars(String s) {
        TreeMap<Character, Deque<Integer>> charIndices = new TreeMap<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch != '*') {
                charIndices.putIfAbsent(ch, new ArrayDeque<>());
                charIndices.get(ch).addLast(i);
            } else {
                for (char key : charIndices.keySet()) {
                    if (!charIndices.get(key).isEmpty()) {
                        int idx = charIndices.get(key).pollLast();
                        sb.setCharAt(idx, '#');
                        break;
                    }
                }
                sb.setCharAt(i, '#');
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch != '#') {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LexicographicallyMinimumAfterRemovingStars solver = new LexicographicallyMinimumAfterRemovingStars();
        System.out.println(solver.clearStars("aaba*")); // aab
        System.out.println(solver.clearStars("abc"));   // abc
    }
}
