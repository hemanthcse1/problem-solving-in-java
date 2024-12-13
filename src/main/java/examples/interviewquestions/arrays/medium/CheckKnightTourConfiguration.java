package examples.interviewquestions.arrays.medium;

public class CheckKnightTourConfiguration {

    public static boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int[][] pos = new int[n*n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pos[grid[i][j]][0] = i;
                pos[grid[i][j]][1] = j;
            }
        }
        if (pos[0][0] != 0 || pos[0][1] != 0) return false;
        for (int i = 0; i < n*n - 1; i++) {
            int r1 = pos[i][0], c1 = pos[i][1], r2 = pos[i+1][0], c2 = pos[i+1][1];
            int dr = Math.abs(r1 - r2), dc = Math.abs(c1 - c2);
            if (!((dr == 2 && dc == 1) || (dr == 1 && dc == 2))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,11,16,5,20},
                {17,4,19,10,15},
                {12,1,8,21,6},
                {3,18,23,14,9},
                {24,13,2,7,22}
        };
        System.out.println(checkValidGrid(grid));
    }
}
