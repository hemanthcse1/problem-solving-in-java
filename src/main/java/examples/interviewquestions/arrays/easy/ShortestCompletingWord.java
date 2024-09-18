package examples.interviewquestions.arrays.easy;

public class ShortestCompletingWord {
    private int[] getLetterCounts(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                counts[Character.toLowerCase(c) - 'a']++;
            }
        }
        return counts;
    }

    private boolean canComplete(int[] licenseCounts, String word) {
        int[] wordCounts = new int[26];
        for (char c : word.toCharArray()) {
            wordCounts[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (licenseCounts[i] > wordCounts[i]) {
                return false;
            }
        }
        return true;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licenseCounts = getLetterCounts(licensePlate);

        String shortestWord = null;

        for (String word : words) {
            if (canComplete(licenseCounts, word)) {
                if (shortestWord == null || word.length() < shortestWord.length()) {
                    shortestWord = word;
                }
            }
        }

        return shortestWord;
    }

    public static void main(String[] args) {
        ShortestCompletingWord solution = new ShortestCompletingWord();


        String licensePlate1 = "1s3 PSt";
        String[] words1 = {"step", "steps", "stripe", "stepple"};
        System.out.println("Test case 1 output: " + solution.shortestCompletingWord(licensePlate1, words1));


        String licensePlate2 = "1s3 456";
        String[] words2 = {"looks", "pest", "stew", "show"};
        System.out.println("Test case 2 output: " + solution.shortestCompletingWord(licensePlate2, words2));
    }
}
