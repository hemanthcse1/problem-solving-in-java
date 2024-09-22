package examples.interviewquestions.arrays.easy;

import java.util.List;

public class SumIndicesWithKSetBits {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                sum += nums.get(i);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        SumIndicesWithKSetBits sol = new SumIndicesWithKSetBits();

        List<Integer> nums1 = List.of(5, 10, 1, 5, 2);
        int k1 = 1;
        System.out.println(sol.sumIndicesWithKSetBits(nums1, k1));

        List<Integer> nums2 = List.of(4, 3, 2, 1);
        int k2 = 2;
        System.out.println(sol.sumIndicesWithKSetBits(nums2, k2));
    }
}
