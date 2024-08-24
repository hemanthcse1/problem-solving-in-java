package examples.interviewquestions.strings.easy;

public class VowelStringsCounter {

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "orange", "umbrella", "end", "ice", "oval"};
        int left = 0;
        int right = 4;
        System.out.println(countVowelStringsInRange(words, left, right));
    }

    public static int countVowelStringsInRange(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i]
                    .charAt(words[i].length() - 1))) {
                count++;
            }
        }
        return count;
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
