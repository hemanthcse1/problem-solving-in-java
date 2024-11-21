package examples.interviewquestions.arrays.medium;

public class MaximumPrimeDifferences {
    public int maxPrimeDifference(int[] nums) {
        boolean[] isPrime = new boolean[101];
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= 100; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= 100; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 100; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int firstPrimeIndex = -1;
        int lastPrimeIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (isPrime[nums[i]]) {
                if (firstPrimeIndex == -1) {
                    firstPrimeIndex = i;
                }
                lastPrimeIndex = i;
            }
        }

        return (lastPrimeIndex - firstPrimeIndex);
    }

    public static void main(String[] args) {
        MaximumPrimeDifferences solution = new MaximumPrimeDifferences();

        int[] nums1 = {4, 2, 9, 5, 3};
        System.out.println(solution.maxPrimeDifference(nums1));

        int[] nums2 = {4, 8, 2, 8};
        System.out.println(solution.maxPrimeDifference(nums2));
    }
}
