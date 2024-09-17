package examples.interviewquestions.arrays.easy;

public class ImageSmoother {

    private static final int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = img[i][j];
                int count = 1;

                for (int[] direction : directions) {
                    int newRow = i + direction[0];
                    int newCol = j + direction[1];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        sum += img[newRow][newCol];
                        count++;
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ImageSmoother smoother = new ImageSmoother();

        int[][] img1 = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] result1 = smoother.imageSmoother(img1);
        printMatrix(result1);

        int[][] img2 = {{100,200,100},{200,50,200},{100,200,100}};
        int[][] result2 = smoother.imageSmoother(img2);
        printMatrix(result2);
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
