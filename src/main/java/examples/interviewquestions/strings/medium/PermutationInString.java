package examples.interviewquestions.strings.medium;

import java.util.Arrays;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(s1Count, s2Count)) return true;
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
        }

        return Arrays.equals(s1Count, s2Count);
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();

        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(permutationInString.checkInclusion(s1, s2));

        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(permutationInString.checkInclusion(s1, s2));
    }
}
