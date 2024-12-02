package examples.interviewquestions.arrays.medium;

public class NumMagicSquaresInside {

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        int[] nums = new int[16];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = grid[row + i][col + j];
                if (value < 1 || value > 9 || nums[value] == 1) {
                    return false;
                }
                nums[value] = 1;
            }
        }

        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        return grid[row][col] + grid[row][col + 1] + grid[row][col + 2] == sum &&
                grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2] == sum &&
                grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2] == sum &&
                grid[row][col] + grid[row + 1][col] + grid[row + 2][col] == sum &&
                grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1] == sum &&
                grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2] == sum &&
                grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] == sum &&
                grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] == sum;
    }

    public static void main(String[] args) {
        NumMagicSquaresInside solution = new NumMagicSquaresInside();

        int[][] grid1 = {
                {4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}
        };

        int[][] grid2 = {
                {8}
        };

        System.out.println("Test Case 1: " + solution.numMagicSquaresInside(grid1));
        System.out.println("Test Case 2: " + solution.numMagicSquaresInside(grid2));
    }
}
