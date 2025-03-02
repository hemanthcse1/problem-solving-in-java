package examples.daily.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwo2DArrays {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;


        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i]);
                i++;
            } else {
                result.add(nums2[j]);
                j++;
            }
        }


        while (i < nums1.length) {
            result.add(nums1[i++]);
        }
        while (j < nums2.length) {
            result.add(nums2[j++]);
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeTwo2DArrays solution = new MergeTwo2DArrays();


        int[][] nums1 = {{1,2},{2,3},{4,5}}, nums2 = {{1,4},{3,2},{4,1}};
        System.out.println(Arrays.deepToString(solution.mergeArrays(nums1, nums2)));


        int[][] nums3 = {{2,4},{3,6},{5,5}}, nums4 = {{1,3},{4,3}};
        System.out.println(Arrays.deepToString(solution.mergeArrays(nums3, nums4)));

    }
}
