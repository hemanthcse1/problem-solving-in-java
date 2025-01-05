package examples.daily.medium.january;

public class ShiftingLettersII {

    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftAmounts = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) {
                shiftAmounts[start] += 1;
                if (end + 1 < n) {
                    shiftAmounts[end + 1] -= 1;
                }
            } else {
                shiftAmounts[start] -= 1;
                if (end + 1 < n) {
                    shiftAmounts[end + 1] += 1;
                }
            }
        }

        int netShift = 0;
        char[] result = s.toCharArray();

        for (int i = 0; i < n; i++) {
            netShift += shiftAmounts[i];

            int newPos = (result[i] - 'a' + netShift) % 26;
            if (newPos < 0) {
                newPos += 26;
            }
            result[i] = (char) ('a' + newPos);
        }

        return new String(result);
    }

    public static void main(String[] args) {

        String s1 = "abc";
        int[][] shifts1 = {
                {0, 1, 0},
                {1, 2, 1},
                {0, 2, 1}
        };

        System.out.println("Input: s = \"abc\", shifts = [[0,1,0],[1,2,1],[0,2,1]]");
        System.out.println("Output: " + shiftingLetters(s1, shifts1));
        System.out.println();


        String s2 = "dztz";
        int[][] shifts2 = {
                {0, 0, 0},
                {1, 1, 1}
        };

        System.out.println("Input: s = \"dztz\", shifts = [[0,0,0],[1,1,1]]");
        System.out.println("Output: " + shiftingLetters(s2, shifts2));
    }
}
