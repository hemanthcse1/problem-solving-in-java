package examples.daily.april;

public class CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        int left = 0;
        long sum = 0, result = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }
            result += (right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        CountSubarraysWithScoreLessThanK solution = new CountSubarraysWithScoreLessThanK();
        int[] nums1 = {2, 1, 4, 3, 5};
        long k1 = 10;
        System.out.println(solution.countSubarrays(nums1, k1));

        int[] nums2 = {1, 1, 1};
        long k2 = 5;
        System.out.println(solution.countSubarrays(nums2, k2));
    }
}
