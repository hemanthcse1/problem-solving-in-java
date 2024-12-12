package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class MatrixBlockSum {

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i-1][j-1]
                        + prefix[i-1][j]
                        + prefix[i][j-1]
                        - prefix[i-1][j-1];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);
                int r2 = Math.min(i + k, m - 1);
                int c2 = Math.min(j + k, n - 1);
                ans[i][j] = prefix[r2+1][c2+1]
                        - prefix[r2+1][c1]
                        - prefix[r1][c2+1]
                        + prefix[r1][c1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        int[][] result = matrixBlockSum(mat, k);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
