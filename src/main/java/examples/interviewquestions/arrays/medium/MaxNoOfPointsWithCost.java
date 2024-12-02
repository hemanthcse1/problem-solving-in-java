package examples.interviewquestions.arrays.medium;

public class MaxNoOfPointsWithCost {

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] prevRow = new long[n];

        for (int j = 0; j < n; j++) {
            prevRow[j] = points[0][j];
        }

        for (int i = 1; i < m; i++) {
            long[] leftMax = new long[n];
            long[] rightMax = new long[n];
            long[] currRow = new long[n];

            leftMax[0] = prevRow[0];
            for (int j = 1; j < n; j++) {
                leftMax[j] = Math.max(leftMax[j - 1] - 1, prevRow[j]);
            }

            rightMax[n - 1] = prevRow[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1] - 1, prevRow[j]);
            }

            for (int j = 0; j < n; j++) {
                currRow[j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);
            }

            prevRow = currRow;
        }

        long maxPoints = 0;
        for (long val : prevRow) {
            maxPoints = Math.max(maxPoints, val);
        }
        return maxPoints;
    }

    public static void main(String[] args) {
        MaxNoOfPointsWithCost solution = new MaxNoOfPointsWithCost();

        int[][] points1 = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1}};
        int[][] points2 = {{1, 5}, {2, 3}, {4, 2}};

        System.out.println(solution.maxPoints(points1));
        System.out.println(solution.maxPoints(points2));
    }

}
