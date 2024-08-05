package examples.interviewquestions.arrays;

public class NeitherMinNorMax {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 4};
        System.out.println(findNumber(nums1));
    }

    public static int findNumber(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        for (int num : nums) {
            if (num != min && num != max) {
                return num;
            }
        }
        return -1;
    }
}
