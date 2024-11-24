package examples.daily;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalSum = 0;
        int minAbsValue = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value);
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
                if (value < 0) {
                    negativeCount++;
                }
            }
        }

        if (negativeCount % 2 == 0) {
            return totalSum;
        } else {
            return totalSum - 2 * minAbsValue;
        }
    }

    public static void main(String[] args) {
        MaximumMatrixSum solution = new MaximumMatrixSum();
        int[][] matrix1 = {{1, -1}, {-1, 1}};
        System.out.println(solution.maxMatrixSum(matrix1));

        int[][] matrix2 = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};
        System.out.println(solution.maxMatrixSum(matrix2));
    }
}
