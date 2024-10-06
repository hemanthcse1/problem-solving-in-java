package examples.interviewquestions.arrays.easy;

public class ProjectionArea {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyProjection = 0, yzProjection = 0, zxProjection = 0;

        int[] maxRow = new int[n];
        int[] maxCol = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    xyProjection++;
                }
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            zxProjection += maxRow[i];
            yzProjection += maxCol[i];
        }

        return xyProjection + yzProjection + zxProjection;
    }

    public static void main(String[] args) {
        ProjectionArea sol = new ProjectionArea();
        int[][] grid1 = {{1,2}, {3,4}};
        int[][] grid2 = {{2}};
        int[][] grid3 = {{1,0}, {0,2}};

        System.out.println(sol.projectionArea(grid1));
        System.out.println(sol.projectionArea(grid2));
        System.out.println(sol.projectionArea(grid3));
    }
}
