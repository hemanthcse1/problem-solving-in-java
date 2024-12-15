package examples.interviewquestions.strings.medium;

public class MinimumLengthAfterOperations {

    public int minimizeLength(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int result = 0;
        for (int f : freq) {
            if (f == 0) {
                continue;
            } else if (f < 3) {
                result += f;
            } else {
                result += (f % 2 == 0) ? 2 : 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumLengthAfterOperations solver = new MinimumLengthAfterOperations();

        String s1 = "abaacbcbb";
        System.out.println(solver.minimizeLength(s1));

        String s2 = "aa";
        System.out.println(solver.minimizeLength(s2));
    }
}
