package examples.hashtables.easy;

public class PermutationDifference {
    public static int permutationDifference(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            throw new IllegalArgumentException("Strings must be non-null and of the same length.");
        }

        int difference = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int indexInT = t.indexOf(ch);
            difference += Math.abs(i - indexInT);
        }

        return difference;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "edcba";

        int result = permutationDifference(s, t);
        System.out.println("Permutation Difference: " + result);
    }
}
