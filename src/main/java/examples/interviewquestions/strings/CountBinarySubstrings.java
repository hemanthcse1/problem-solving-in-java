package examples.interviewquestions.strings;

public class CountBinarySubstrings {
    public static void main(String[] args) {
        String s = "00110011";
        int result = countBinarySubstrings(s);
        System.out.println("Number of valid substrings: " + result);
    }

    public static int countBinarySubstrings(String s) {
        int count = 0;
        int prevLength = 0;
        int curLength = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLength++;
            } else {
                count += Math.min(prevLength, curLength);
                prevLength = curLength;
                curLength = 1;
            }
        }
        count += Math.min(prevLength, curLength);

        return count;
    }
}
