package examples.interviewquestions.strings;

public class FindWordsFormedByCharacters {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int result = countCharacters(words, chars);
        System.out.println("Sum of lengths of all good strings: " + result);
    }

    public static int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        int sumLengths = 0;
        for (String word : words) {
            int[] wordCount = new int[26];
            for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;
            }
            if (canFormWord(charCount, wordCount)) {
                sumLengths += word.length();
            }
        }

        return sumLengths;
    }

    private static boolean canFormWord(int[] charCount, int[] wordCount) {
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] > charCount[i]) {
                return false;
            }
        }
        return true;
    }
}
