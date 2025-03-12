package examples.daily.march;

public class MaximumCountOfPosNeg {

    public static void main(String[] args) {
        int[] example1 = {-2, -1, -1, 1, 2, 3};
        int[] example2 = {-3, -2, -1, 0, 0, 1, 2};
        int[] example3 = {5, 20, 66, 1314};


        System.out.println("Example 1: " + maximumCount(example1)); //  3
        System.out.println("Example 2: " + maximumCount(example2)); //  3
        System.out.println("Example 3: " + maximumCount(example3)); //  4
    }

    public static int maximumCount(int[] nums) {
        int n = nums.length;

        int idxNeg = firstIndexGreaterEqual(nums, 0);
        int negCount = idxNeg;

        int idxPos = firstIndexGreater(nums, 0);
        int posCount = n - idxPos;

        return Math.max(negCount, posCount);
    }

    private static int firstIndexGreaterEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    private static int firstIndexGreater(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
