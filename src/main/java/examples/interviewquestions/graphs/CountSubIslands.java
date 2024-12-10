package examples.interviewquestions.graphs;

public class CountSubIslands {

    public static void main(String[] args) {
        int[][] grid1 = {
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };

        int[][] grid2 = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
        };


        int result = countSubIslands(grid1, grid2);
        System.out.println(result);
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    if (dfs(grid1, grid2, visited, i, j, m, n)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0 || visited[i][j]) {
            return true;
        }

        visited[i][j] = true;
        boolean isSubIsland = true;
        if (grid1[i][j] == 0 && grid2[i][j] == 1) {
            isSubIsland = false;
        }

        // Check all four directions
        isSubIsland &= dfs(grid1, grid2, visited, i+1, j, m, n);
        isSubIsland &= dfs(grid1, grid2, visited, i-1, j, m, n);
        isSubIsland &= dfs(grid1, grid2, visited, i, j+1, m, n);
        isSubIsland &= dfs(grid1, grid2, visited, i, j-1, m, n);

        return isSubIsland;
    }
}
