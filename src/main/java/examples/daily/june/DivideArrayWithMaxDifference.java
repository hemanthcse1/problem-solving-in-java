package examples.daily.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayWithMaxDifference {

    public int[][] divideArray(int[] nums, int k){
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i< nums.length; i +=3){
            int a = nums[i];
            int b = nums[i+1];
            int c = nums[i+2];


            if (c - a > k){
                return new int[0][0];
            }

            result.add(Arrays.asList(a,b,c));
        }

        int[][] output = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> triplet = result.get(i);
            for (int j = 0; j < 3; j++) {
                output[i][j] = triplet.get(j);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        DivideArrayWithMaxDifference divideArrayWithMaxDifference = new DivideArrayWithMaxDifference();

        int[] nums1 = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k1 = 2;
        System.out.println("Example 1 Output:");
        divideArrayWithMaxDifference.divideArray(nums1, k1);

        int[] nums2 = {2, 4, 2, 2, 5, 2};
        int k2 = 2;
        System.out.println("Example 2 Output:");
        divideArrayWithMaxDifference.divideArray(nums2, k2);

        int[] nums3 = {4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11};
        int k3 = 14;
        System.out.println("Example 3 Output:");
        divideArrayWithMaxDifference.divideArray(nums3, k3);
    }


}
