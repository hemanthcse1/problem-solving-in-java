package examples.interviewquestions.arrays.easy;

public class KOrOfArray {
    public static int findKOr(int[] nums, int k) {
        int result = 0;
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            if (count >= k) {
                result |= (1 << bit);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        int result = findKOr(nums, k);
        System.out.println("The K-or of the array is: " + result);
    }
}
