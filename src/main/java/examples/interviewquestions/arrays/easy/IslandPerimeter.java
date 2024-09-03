package examples.interviewquestions.arrays.easy;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter solution = new IslandPerimeter();

        int[][] grid1 = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(solution.islandPerimeter(grid1));

        int[][] grid2 = {
                {1}
        };
        System.out.println(solution.islandPerimeter(grid2));

        int[][] grid3 = {
                {1, 0}
        };
        System.out.println(solution.islandPerimeter(grid3));
    }
}
