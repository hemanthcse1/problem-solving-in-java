package examples.interviewquestions.arrays.easy;

public class GridConditionChecker {
    public static boolean checkGridConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i + 1 < m && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }

                if (j + 1 < n && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {1, 4, 5},
                {1, 6, 7}
        };

        System.out.println("Does the grid satisfy the conditions? " + checkGridConditions(grid));
    }
}
