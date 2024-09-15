package examples.interviewquestions.arrays.easy;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }

        maxCount = Math.max(maxCount, currentCount);

        return maxCount;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes solution = new FindMaxConsecutiveOnes();

        int[] nums1 = {1, 1, 0, 1, 1, 1};
        System.out.println(solution.findMaxConsecutiveOnes(nums1));

        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println(solution.findMaxConsecutiveOnes(nums2));
    }
}
