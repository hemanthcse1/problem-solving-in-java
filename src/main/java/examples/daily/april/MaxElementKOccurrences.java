package examples.daily.april;

public class MaxElementKOccurrences {

    public long countSubarrays(int[] nums, int k){
        int maxElement = Integer.MIN_VALUE;

        for (int num : nums){
            if (num > maxElement){
                maxElement = num;
            }
        }

        long result = 0;
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++){
            if (nums[right] == maxElement){
                count++;
            }

            while (count >= k){
                result += nums.length - right;

                if (nums[left] == maxElement){
                    count--;
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxElementKOccurrences solution = new MaxElementKOccurrences();

        int[] nums1 = {1, 3, 2, 3, 3};
        int k1 = 2;
        System.out.println("Test Case 1 Result: " + solution.countSubarrays(nums1, k1));

        int[] nums2 = {1, 4, 2, 1};
        int k2 = 3;
        System.out.println("Test Case 2 Result: " + solution.countSubarrays(nums2, k2));

    }
}
