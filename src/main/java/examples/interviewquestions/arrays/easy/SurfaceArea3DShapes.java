package examples.interviewquestions.arrays.easy;

public class SurfaceArea3DShapes {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    totalArea += 2;
                    if (j == 0) {
                        totalArea += grid[i][j];
                    } else {
                        totalArea += Math.max(grid[i][j] - grid[i][j-1], 0);
                    }
                    if (j == n - 1) {
                        totalArea += grid[i][j];
                    } else {
                        totalArea += Math.max(grid[i][j] - grid[i][j+1], 0);
                    }
                    if (i == 0) {
                        totalArea += grid[i][j];
                    } else {
                        totalArea += Math.max(grid[i][j] - grid[i-1][j], 0);
                    }
                    if (i == n - 1) {
                        totalArea += grid[i][j];
                    } else {
                        totalArea += Math.max(grid[i][j] - grid[i+1][j], 0);
                    }
                }
            }
        }

        return totalArea;
    }

    public static void main(String[] args) {
        SurfaceArea3DShapes solver = new SurfaceArea3DShapes();
        System.out.println(solver.surfaceArea(new int[][]{{1,2}, {3,4}}));
        System.out.println(solver.surfaceArea(new int[][]{{1,1,1}, {1,0,1}, {1,1,1}}));
        System.out.println(solver.surfaceArea(new int[][]{{2,2,2}, {2,1,2}, {2,2,2}}));
    }
}
