package examples.interviewquestions.strings;

import examples.interviewquestions.stacks.Solution;

public class CountPrefixes {
    public int countPrefixes(String[] words, String s) {
        int count = 0;

        for (String word : words) {
            if (s.startsWith(word)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrefixes solution = new CountPrefixes();

        String[] words = {"a", "b", "c", "ab", "bc", "abc"};
        String s = "abc";
        int result = solution.countPrefixes(words, s);

        System.out.println(result);
    }
}
