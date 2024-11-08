package examples.interviewquestions.strings.medium;

public class ShiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftAmounts = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            shiftAmounts[start] += (direction == 1) ? 1 : -1;
            if (end + 1 < n) {
                shiftAmounts[end + 1] -= (direction == 1) ? 1 : -1;
            }
        }

        int netShift = 0;
        char[] result = s.toCharArray();

        for (int i = 0; i < n; i++) {
            netShift += shiftAmounts[i];

            int newChar = ((result[i] - 'a') + netShift) % 26;
            if (newChar < 0) {
                newChar += 26;
            }
            result[i] = (char) ('a' + newChar);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        ShiftingLettersII solution = new ShiftingLettersII();

        System.out.println(solution.shiftingLetters("abc", new int[][]{{0, 1, 0}, {1, 2, 1}, {0, 2, 1}}));
        System.out.println(solution.shiftingLetters("dztz", new int[][]{{0, 0, 0}, {1, 1, 1}}));
    }
}
