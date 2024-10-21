package examples.interviewquestions.arrays.medium;

public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int F0 = 0;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            F0 += i * nums[i];
        }

        int maxF = F0;

        int currentF = F0;
        for (int k = 1; k < n; k++) {
            currentF = currentF + totalSum - n * nums[n - k];
            maxF = Math.max(maxF, currentF);
        }

        return maxF;
    }

    public static void main(String[] args) {
        RotateFunction solution = new RotateFunction();

        int[] nums1 = {4, 3, 2, 6};
        System.out.println(solution.maxRotateFunction(nums1));

        int[] nums2 = {100};
        System.out.println(solution.maxRotateFunction(nums2));
    }
}
