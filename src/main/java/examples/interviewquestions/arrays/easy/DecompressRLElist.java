package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class DecompressRLElist {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];

            for (int j = 0; j < freq; j++) {
                resultList.add(val);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        DecompressRLElist solution = new DecompressRLElist();

        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.decompressRLElist(nums1);
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums2 = {1, 1, 2, 3};
        int[] result2 = solution.decompressRLElist(nums2);
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
