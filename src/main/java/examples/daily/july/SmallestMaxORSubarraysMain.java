package examples.daily.july;

import java.util.Arrays;

public class SmallestMaxORSubarraysMain {

    public static void main(String[] args) {
        SmallestMaxORSubarraysMain solution = new SmallestMaxORSubarraysMain();

        int[] nums1 = {1, 0, 2, 1, 3};
        int[] nums2 = {1, 2};
        int[] nums3 = {0, 0, 0, 0};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(solution.smallestSubarrays(nums1))); // [3, 3, 2, 2, 1]

        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(solution.smallestSubarrays(nums2))); // [2, 1]

        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Output: " + Arrays.toString(solution.smallestSubarrays(nums3))); // [1, 1, 1, 1]
    }

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] last = new int[32];

        for (int i = n - 1; i >= 0; --i) {
            for (int bit = 0; bit < 32; ++bit) {
                if ((nums[i] & (1 << bit)) > 0) {
                    last[bit] = i;
                }
            }

            int farthest = i;
            for (int bit = 0; bit < 32; ++bit) {
                farthest = Math.max(farthest, last[bit]);
            }

            answer[i] = farthest - i + 1;
        }

        return answer;
    }
}
