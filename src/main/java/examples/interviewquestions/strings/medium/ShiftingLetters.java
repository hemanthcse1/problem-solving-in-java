package examples.interviewquestions.strings.medium;

public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] result = s.toCharArray();

        long cumulativeShift = 0;
        for (int i = n - 1; i >= 0; i--) {
            cumulativeShift = (cumulativeShift + shifts[i]) % 26;
            result[i] = shiftChar(result[i], (int)cumulativeShift);
        }

        return new String(result);
    }

    private char shiftChar(char c, int shift) {
        return (char)((c - 'a' + shift) % 26 + 'a');
    }

    public static void main(String[] args) {
        ShiftingLetters solution = new ShiftingLetters();

        String s1 = "abc";
        int[] shifts1 = {3, 5, 9};
        System.out.println("Result for s = \"abc\", shifts = [3, 5, 9]: " + solution.shiftingLetters(s1, shifts1));

        String s2 = "aaa";
        int[] shifts2 = {1, 2, 3};
        System.out.println("Result for s = \"aaa\", shifts = [1, 2, 3]: " + solution.shiftingLetters(s2, shifts2));
    }
}
