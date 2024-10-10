package examples.interviewquestions.strings.easy;

public class SubstringInReverse {
    public static boolean hasSubstringInReverse(String s) {
        String reversed = new StringBuilder(s).reverse().toString();


        for (int i = 0; i < s.length() - 1; i++) {
            String substring = s.substring(i, i + 2);
            if (reversed.contains(substring)) {
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {

        String s1 = "leetcode";
        System.out.println(hasSubstringInReverse(s1));


        String s2 = "abcba";
        System.out.println(hasSubstringInReverse(s2));


        String s3 = "abcd";
        System.out.println(hasSubstringInReverse(s3));
    }
}
