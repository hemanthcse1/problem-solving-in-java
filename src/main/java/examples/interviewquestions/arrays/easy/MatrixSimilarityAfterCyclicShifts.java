package examples.interviewquestions.arrays.easy;

public class MatrixSimilarityAfterCyclicShifts {
    public boolean matrixSimilarityAfterCyclicShifts(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] original = new int[m][n];

        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, original[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            int shift = k % n;
            if (shift != 0) {
                if (i % 2 == 0) {
                    shiftLeft(mat[i], shift);
                } else {
                    shiftRight(mat[i], shift);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != original[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void shiftLeft(int[] row, int shift) {
        int n = row.length;
        int[] temp = new int[n];
        System.arraycopy(row, 0, temp, 0, n);
        for (int i = 0; i < n; i++) {
            row[i] = temp[(i + shift) % n];
        }
    }

    private void shiftRight(int[] row, int shift) {
        int n = row.length;
        int[] temp = new int[n];
        System.arraycopy(row, 0, temp, 0, n);
        for (int i = 0; i < n; i++) {
            row[i] = temp[(i - shift + n) % n];
        }
    }

    public static void main(String[] args) {
        MatrixSimilarityAfterCyclicShifts solution = new MatrixSimilarityAfterCyclicShifts();
        System.out.println(solution.matrixSimilarityAfterCyclicShifts(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 4));
        System.out.println(solution.matrixSimilarityAfterCyclicShifts(new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 2));
        System.out.println(solution.matrixSimilarityAfterCyclicShifts(new int[][]{{2,2},{2,2}}, 3));
    }
}
