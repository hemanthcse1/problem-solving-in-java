package examples.interviewquestions.arrays.easy;

public class ModifyMatrix {
    public int[][] modifyMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] maxInColumn = new int[n];

        for (int j = 0; j < n; j++) {
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] != -1) {
                    maxVal = Math.max(maxVal, matrix[i][j]);
                }
            }
            maxInColumn[j] = maxVal;
        }

        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    answer[i][j] = maxInColumn[j];
                } else {
                    answer[i][j] = matrix[i][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ModifyMatrix sol = new ModifyMatrix();
        int[][] matrix1 = {{1, 2, -1}, {4, -1, 6}, {7, 8, 9}};
        int[][] result1 = sol.modifyMatrix(matrix1);
        for (int[] row : result1) {
            System.out.println(java.util.Arrays.toString(row));
        }

        int[][] matrix2 = {{3, -1}, {5, 2}};
        int[][] result2 = sol.modifyMatrix(matrix2);
        for (int[] row : result2) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
