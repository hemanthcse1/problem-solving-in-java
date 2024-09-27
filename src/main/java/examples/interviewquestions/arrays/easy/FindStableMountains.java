package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class FindStableMountains {
    public List<Integer> findStableMountains(int[] height, int threshold) {
        List<Integer> stableIndices = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                stableIndices.add(i);
            }
        }
        return stableIndices;
    }

    public static void main(String[] args) {
        FindStableMountains sol = new FindStableMountains();

        int[] heights1 = {1, 2, 3, 4, 5};
        int threshold1 = 2;
        System.out.println(sol.findStableMountains(heights1, threshold1));

        int[] heights2 = {10, 1, 10, 1, 10};
        int threshold2 = 3;
        System.out.println(sol.findStableMountains(heights2, threshold2));

        int[] heights3 = {10, 1, 10, 1, 10};
        int threshold3 = 10;
        System.out.println(sol.findStableMountains(heights3, threshold3));
    }
}
