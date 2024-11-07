package examples.interviewquestions.strings.medium;

public class VowelsOfAllSubstrings {
    public long countVowels(String word) {
        long totalVowels = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (isVowel(ch)) {
                totalVowels += (long) (i + 1) * (n - i);
            }
        }

        return totalVowels;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        VowelsOfAllSubstrings solution = new VowelsOfAllSubstrings();

        System.out.println(solution.countVowels("aba"));
        System.out.println(solution.countVowels("abc"));
        System.out.println(solution.countVowels("ltcd"));
    }
}
