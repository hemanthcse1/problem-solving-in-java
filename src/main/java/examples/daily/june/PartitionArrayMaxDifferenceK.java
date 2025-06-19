package examples.daily.june;

import java.util.Arrays;

public class PartitionArrayMaxDifferenceK {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 0;
        int i = 0;

        while (i < nums.length){
            int groupStart = nums[i];
            i++;
            count++;

            while(i < nums.length && nums[i] - groupStart <= k){
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PartitionArrayMaxDifferenceK solution = new PartitionArrayMaxDifferenceK();

        int[] nums1 = {3, 6, 1, 2, 5};
        int k1 = 2;
        System.out.println("Output 1: " + solution.partitionArray(nums1, k1)); //  2

        int[] nums2 = {1, 2, 3};
        int k2 = 1;
        System.out.println("Output 2: " + solution.partitionArray(nums2, k2)); //  2

        int[] nums3 = {2, 2, 4, 5};
        int k3 = 0;
        System.out.println("Output 3: " + solution.partitionArray(nums3, k3)); //  3
    }
}
