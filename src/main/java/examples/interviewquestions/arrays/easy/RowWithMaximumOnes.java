package examples.interviewquestions.arrays.easy;

public class RowWithMaximumOnes {

    public static int[] rowAndMaxOnes(int[][] mat) {
        int maxOnes = -1;
        int rowIndex = -1;

        for (int i = 0; i < mat.length; i++) {
            int onesCount = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    onesCount++;
                }
            }

            if (onesCount > maxOnes) {
                maxOnes = onesCount;
                rowIndex = i;
            }
        }
        return new int[]{rowIndex, maxOnes};
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };

        int[] result = rowAndMaxOnes(mat);
        System.out.println("Row index: " + result[0] + ", Number of ones: " + result[1]);
    }
}
