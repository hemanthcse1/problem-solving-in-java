package examples.daily.medium.january;

public class CountServers {
    public static int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1,0},{0,1}};
        System.out.println(countServers(grid1));

        int[][] grid2 = {{1,0},{1,1}};
        System.out.println(countServers(grid2));

        int[][] grid3 = {
                {1,1,0,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,1}
        };
        System.out.println(countServers(grid3));
    }
}
