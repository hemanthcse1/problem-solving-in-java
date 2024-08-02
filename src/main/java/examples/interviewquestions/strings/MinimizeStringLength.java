package examples.interviewquestions.strings;

import java.util.HashSet;
import java.util.Set;

public class MinimizeStringLength {
    public static int minimizeStringLength(String s) {
        Set<Character> uniqueChars = new HashSet<>();

        for (char ch : s.toCharArray()) {
            uniqueChars.add(ch);
        }

        return uniqueChars.size();
    }

    public static void main(String[] args) {
        String s = "aaabbc";
        System.out.println(minimizeStringLength(s));
    }
}
