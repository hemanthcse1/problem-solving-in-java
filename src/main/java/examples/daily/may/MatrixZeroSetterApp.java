package examples.daily.may;

public class MatrixZeroSetterApp {

    public static void main(String[] args) {
        MatrixZeroSetterApp matrixZeroSetterApp = new MatrixZeroSetterApp();

        int[] nums = {3, 2, 2, 1};
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        matrixZeroSetterApp.isZeroArray(nums,matrix);

        System.out.println("\nMatrix After Setting Zeroes:");
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }

        int[] decrements = new int[n];
        decrements[0] = diff[0];
        for (int i = 1; i < n; i++) {
            decrements[i] = decrements[i - 1] + diff[i];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > decrements[i]) {
                return false;
            }
        }
        return true;
    }
}
