package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class FlipAndInvertImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = image[i][j] ^ 1;
                image[i][j] = image[i][n - j - 1] ^ 1;
                image[i][n - j - 1] = temp;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image1 = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        System.out.println(Arrays.deepToString(flipAndInvertImage(image1)));

        int[][] image2 = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };
        System.out.println(Arrays.deepToString(flipAndInvertImage(image2)));
    }
}
