package examples.daily.june;

import java.util.ArrayDeque;
import java.util.Deque;

public class LexicographicallySmallestRobotPrint {
    public String robotWithString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        int minCharIndex = 0;

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;

            while (minCharIndex < 26 && freq[minCharIndex] == 0) {
                minCharIndex++;
            }

            stack.push(c);

            while (!stack.isEmpty() && (stack.peek() - 'a') <= minCharIndex) {
                result.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LexicographicallySmallestRobotPrint solver = new LexicographicallySmallestRobotPrint();
        System.out.println(solver.robotWithString("zza"));   // Output: "azz"
        System.out.println(solver.robotWithString("bac"));   // Output: "abc"
        System.out.println(solver.robotWithString("bdda"));  // Output: "addb"
    }
}
