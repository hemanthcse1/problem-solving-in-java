package examples.interviewquestions.arrays.easy;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ToeplitzMatrix solution = new ToeplitzMatrix();

        int[][] matrix1 = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println("Test case 1 output: " + solution.isToeplitzMatrix(matrix1));

        int[][] matrix2 = {{1, 2}, {2, 2}};
        System.out.println("Test case 2 output: " + solution.isToeplitzMatrix(matrix2));
    }
}
