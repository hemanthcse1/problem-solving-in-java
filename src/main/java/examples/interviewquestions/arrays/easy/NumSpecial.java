package examples.interviewquestions.arrays.easy;

public class NumSpecial {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (isRowValid(mat, i, j) && isColValid(mat, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean isRowValid(int[][] mat, int row, int col) {
        for (int j = 0; j < mat[0].length; j++) {
            if (j != col && mat[row][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isColValid(int[][] mat, int row, int col) {
        for (int i = 0; i < mat.length; i++) {
            if (i != row && mat[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumSpecial solution = new NumSpecial();

        int[][] mat1 = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        System.out.println(solution.numSpecial(mat1));

        int[][] mat2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solution.numSpecial(mat2));
    }
}
