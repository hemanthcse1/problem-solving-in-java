package examples.interviewquestions.stacks.medium;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                resultStack.push(currentString.toString());
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                int count = countStack.pop();
                StringBuilder decodedString = new StringBuilder(resultStack.pop());
                for (int i = 0; i < count; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString decoder = new DecodeString();

        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";

        System.out.println(decoder.decodeString(s1)); // Output: "aaabcbc"
        System.out.println(decoder.decodeString(s2)); // Output: "accaccacc"
        System.out.println(decoder.decodeString(s3)); // Output: "abcabccdcdcdef"
    }
}
