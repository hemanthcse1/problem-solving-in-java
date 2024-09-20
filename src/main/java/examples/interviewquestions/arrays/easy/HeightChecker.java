package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        HeightChecker solution = new HeightChecker();

        int[] heights1 = {1, 1, 4, 2, 1, 3};
        System.out.println(solution.heightChecker(heights1));

        int[] heights2 = {5, 1, 2, 3, 4};
        System.out.println(solution.heightChecker(heights2));

        int[] heights3 = {1, 2, 3, 4, 5};
        System.out.println(solution.heightChecker(heights3));
    }
}
