package examples.interviewquestions.strings.medium;

public class MakeStringSubsequence {

    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            if (c1 == c2 || (c1 + 1 - 'a') % 26 + 'a' == c2) {
                j++;
            }
            i++;
        }
        return j == str2.length();
    }

    public static void main(String[] args) {
        MakeStringSubsequence solution = new MakeStringSubsequence();
        System.out.println(solution.canMakeSubsequence("abc", "ad"));
        System.out.println(solution.canMakeSubsequence("zc", "ad"));
        System.out.println(solution.canMakeSubsequence("ab", "d"));
    }
}
