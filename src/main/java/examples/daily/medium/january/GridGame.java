package examples.daily.medium.january;

public class GridGame {
    public static long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] topPrefix = new long[n + 1];
        long[] bottomPrefix = new long[n + 1];


        for (int i = 0; i < n; i++) {
            topPrefix[i + 1] = topPrefix[i] + grid[0][i];
        }

        for (int i = 0; i < n; i++) {
            bottomPrefix[i + 1] = bottomPrefix[i] + grid[1][i];
        }

        long result = Long.MAX_VALUE;


        for (int c = 0; c < n; c++) {

            long scoreBottom = bottomPrefix[c];


            long scoreTop = topPrefix[n] - topPrefix[c + 1];

            long secondRobotScore = Math.max(scoreBottom, scoreTop);


            result = Math.min(result, secondRobotScore);
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] grid1 = {
                {2, 5, 4},
                {1, 5, 1}
        };
        System.out.println(gridGame(grid1));


        int[][] grid2 = {
                {3, 3, 1},
                {8, 5, 2}
        };
        System.out.println(gridGame(grid2));


        int[][] grid3 = {
                {1, 3, 1, 15},
                {1, 3, 3, 1}
        };
        System.out.println(gridGame(grid3));
    }
}
