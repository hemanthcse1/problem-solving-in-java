package examples.hashtables.easy;

public class IncreasingDecreasingString {
    public static String sortString(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        int n = s.length();

        while (result.length() < n) {
            for (int i = 0; i < 26; i++) {
                if (charCount[i] > 0) {
                    result.append((char) (i + 'a'));
                    charCount[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (charCount[i] > 0) {
                    result.append((char) (i + 'a'));
                    charCount[i]--;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        String result = sortString(s);
        System.out.println("Resulting string: " + result);
    }
}
