package examples.interviewquestions.arrays.easy;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[][] reshapedMatrix = new int[r][c];
        int row = 0, col = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reshapedMatrix[row][col] = mat[i][j];
                col++;

                if (col == c) {
                    row++;
                    col = 0;
                }
            }
        }

        return reshapedMatrix;
    }

    public static void main(String[] args) {
        MatrixReshape solution = new MatrixReshape();

        int[][] mat1 = {{1, 2}, {3, 4}};
        int r1 = 1, c1 = 4;
        int[][] reshaped1 = solution.matrixReshape(mat1, r1, c1);
        printMatrix(reshaped1);

        int[][] mat2 = {{1, 2}, {3, 4}};
        int r2 = 2, c2 = 4;
        int[][] reshaped2 = solution.matrixReshape(mat2, r2, c2);
        printMatrix(reshaped2);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
