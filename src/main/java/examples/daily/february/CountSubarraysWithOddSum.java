package examples.daily.february;

public class CountSubarraysWithOddSum {

    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int oddCount = 0, evenCount = 1;
        int prefixSum = 0, result = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {

                result = (result + oddCount) % MOD;
                evenCount++;
            } else {

                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CountSubarraysWithOddSum solution = new CountSubarraysWithOddSum();

        System.out.println(solution.numOfSubarrays(new int[]{1,3,5})); //  4
        System.out.println(solution.numOfSubarrays(new int[]{2,4,6})); //  0
        System.out.println(solution.numOfSubarrays(new int[]{1,2,3,4,5,6,7})); //  16
    }
}
