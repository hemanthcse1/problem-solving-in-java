package examples.interviewquestions.strings.easy;

public class MakeFancyString {

    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (i >= 2 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                continue;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MakeFancyString solution = new MakeFancyString();

        String s1 = "leeetcode";
        System.out.println(solution.makeFancyString(s1));

        String s2 = "aaabaaaa";
        System.out.println(solution.makeFancyString(s2));

        String s3 = "aab";
        System.out.println(solution.makeFancyString(s3));
    }

}
