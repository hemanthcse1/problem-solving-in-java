package examples.interviewquestions.enumerations.easy;

public class LongestAlternatingSubarray {
    public static int findLongestAlternatingSubarray(int[] nums) {
        int maxLength = -1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i-1] == 1 && currentLength % 2 == 1) ||
                    (nums[i-1] - nums[i] == 1 && currentLength % 2 == 0)) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else if (nums[i] - nums[i-1] == 1) {
                currentLength = 2;
            } else {
                currentLength = 1;
            }
        }

        return maxLength > 1 ? maxLength : -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 2, 3, 2};
        int[] nums2 = {1, 3, 5, 7};
        int[] nums3 = {3, 2, 3, 2, 3, 2};

        System.out.println(findLongestAlternatingSubarray(nums1));
        System.out.println(findLongestAlternatingSubarray(nums2));
        System.out.println(findLongestAlternatingSubarray(nums3));
    }
}
