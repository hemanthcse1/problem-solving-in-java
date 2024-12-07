package examples.daily;

public class MinimumLimitBallsInBag {

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canDivide(int[] nums, int maxSize, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            if (num > maxSize) {
                operations += (num - 1) / maxSize;
            }
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumLimitBallsInBag solution = new MinimumLimitBallsInBag();

        int[] nums1 = {9};
        int maxOperations1 = 2;
        System.out.println(solution.minimumSize(nums1, maxOperations1));

        int[] nums2 = {2, 4, 8, 2};
        int maxOperations2 = 4;
        System.out.println(solution.minimumSize(nums2, maxOperations2));
    }
}
