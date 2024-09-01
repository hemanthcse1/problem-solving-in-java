package examples.interviewquestions.strings.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumKeyPresses {
    public static int minKeyPresses(String word) {
        int[] frequency = new int[26];


        for (char ch : word.toCharArray()) {
            frequency[ch - 'a']++;
        }


        Arrays.sort(frequency);

        int totalPresses = 0;
        int keyPosition = 1;

        for (int i = 25; i >= 0; i--) {
            if (frequency[i] == 0) break;

            totalPresses += frequency[i] * keyPosition;

            if ((26 - i) % 9 == 0) {
                keyPosition++;
            }
        }

        return totalPresses;
    }

    public static void main(String[] args) {
        System.out.println(minKeyPresses("xycdefghij")); // Output: 12
        System.out.println(minKeyPresses("apple")); // Output: 5
        System.out.println(minKeyPresses("banana")); // Output: 9
        System.out.println(minKeyPresses("hello")); // Output: 7
    }
}
