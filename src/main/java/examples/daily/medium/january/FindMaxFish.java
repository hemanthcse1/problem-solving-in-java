package examples.daily.medium.january;

public class FindMaxFish {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    maxFish = Math.max(maxFish, dfs(grid, i, j, visited));
                }
            }
        }

        return maxFish;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        visited[r][c] = true;
        int fish = grid[r][c];

        fish += dfs(grid, r + 1, c, visited);
        fish += dfs(grid, r - 1, c, visited);
        fish += dfs(grid, r, c + 1, visited);
        fish += dfs(grid, r, c - 1, visited);

        return fish;
    }

    public static void main(String[] args) {
        FindMaxFish findMaxFish = new FindMaxFish();


        int[][] grid1 = {
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}
        };
        System.out.println(findMaxFish.findMaxFish(grid1)); // 7


        int[][] grid2 = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };
        System.out.println(findMaxFish.findMaxFish(grid2)); // 1
    }
}
