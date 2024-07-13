package examples.interviewquestions.twopointers;

public class PrefixOfStringArray {

    public static void main(String[] args) {
        String s = "iloveleetcode";
        String[] codes = {"i", "love", "leetcode", "app;e"};
        boolean result = prefixOfStringArray(s, codes);
        System.out.println("Result -> " + result);
    }

    public static boolean prefixOfStringArray(String s, String[] words) {
        StringBuilder prefix = new StringBuilder();

        for (String word : words) {
            prefix.append(word);
            if (prefix.toString().equals(s)) {
                return true;
            } else if (prefix.length() > s.length()) {
                return false;
            }

        }
        return false;
    }
}
