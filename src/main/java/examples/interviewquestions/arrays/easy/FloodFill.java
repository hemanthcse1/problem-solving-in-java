package examples.interviewquestions.arrays.easy;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor);
        }

        return image;
    }

    private void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row + 1, col, oldColor, newColor);
        dfs(image, row - 1, col, oldColor, newColor);
        dfs(image, row, col + 1, oldColor, newColor);
        dfs(image, row, col - 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        FloodFill solution = new FloodFill();

        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result1 = solution.floodFill(image1, 1, 1, 2);
        printImage(result1);

        int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
        int[][] result2 = solution.floodFill(image2, 0, 0, 0);
        printImage(result2);
    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
