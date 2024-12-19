package examples.interviewquestions.hashmaps.medium;

public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {

        String word1a = "abc", word2a = "bca";
        System.out.println(closeStrings(word1a, word2a));

        String word1b = "a", word2b = "aa";
        System.out.println(closeStrings(word1b, word2b));

    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        java.util.Arrays.sort(freq1);
        java.util.Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
