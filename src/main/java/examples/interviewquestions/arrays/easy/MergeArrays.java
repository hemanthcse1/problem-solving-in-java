package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class MergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0], val1 = nums1[i][1];
            int id2 = nums2[j][0], val2 = nums2[j][1];

            if (id1 == id2) {
                result.add(new int[]{id1, val1 + val2});
                i++;
                j++;
            } else if (id1 < id2) {
                result.add(new int[]{id1, val1});
                i++;
            } else {
                result.add(new int[]{id2, val2});
                j++;
            }
        }

        while (i < nums1.length) {
            result.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }

        while (j < nums2.length) {
            result.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeArrays solution = new MergeArrays();

        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] result1 = solution.mergeArrays(nums1, nums2);
        printResult(result1);

        int[][] nums3 = {{2, 4}, {3, 6}, {5, 5}};
        int[][] nums4 = {{1, 3}, {4, 3}};
        int[][] result2 = solution.mergeArrays(nums3, nums4);
        printResult(result2);
    }

    private static void printResult(int[][] result) {
        for (int[] pair : result) {
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
        }
        System.out.println();
    }
}
