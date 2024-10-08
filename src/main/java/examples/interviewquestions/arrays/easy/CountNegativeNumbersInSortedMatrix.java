package examples.interviewquestions.arrays.easy;

public class CountNegativeNumbersInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int row = 0;
        int col = n - 1;
        int count = 0;

        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {

                count += (m - row);
                col--;  // Move left
            } else {
                row++;  // Move down
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountNegativeNumbersInSortedMatrix solver = new CountNegativeNumbersInSortedMatrix();
        System.out.println(solver.countNegatives(new int[][]{{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}}));
        System.out.println(solver.countNegatives(new int[][]{{3,2}, {1,0}}));
    }
}
