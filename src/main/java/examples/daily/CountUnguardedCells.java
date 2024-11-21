package examples.daily;

public class CountUnguardedCells {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] wall : walls) grid[wall[0]][wall[1]] = 1;
        for (int[] guard : guards) grid[guard[0]][guard[1]] = 2;

        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            for (int i = x - 1; i >= 0; i--) {
                if (grid[i][y] == 1 || grid[i][y] == 2) break;
                grid[i][y] = 3;
            }
            for (int i = x + 1; i < m; i++) {
                if (grid[i][y] == 1 || grid[i][y] == 2) break;
                grid[i][y] = 3;
            }
            for (int j = y - 1; j >= 0; j--) {
                if (grid[x][j] == 1 || grid[x][j] == 2) break;
                grid[x][j] = 3;
            }
            for (int j = y + 1; j < n; j++) {
                if (grid[x][j] == 1 || grid[x][j] == 2) break;
                grid[x][j] = 3;
            }
        }

        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) unguardedCount++;
            }
        }

        return unguardedCount;
    }

    public static void main(String[] args) {
        CountUnguardedCells solution = new CountUnguardedCells();
        System.out.println(solution.countUnguarded(4, 6, new int[][]{{0, 0}, {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}}));
        System.out.println(solution.countUnguarded(3, 3, new int[][]{{1, 1}}, new int[][]{{0, 1}, {1, 0}, {2, 1}, {1, 2}}));
    }
}
