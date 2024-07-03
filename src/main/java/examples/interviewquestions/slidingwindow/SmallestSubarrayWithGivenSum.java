package examples.interviewquestions.slidingwindow;

public class SmallestSubarrayWithGivenSum {
    public static int smallestSubarrayWithSum(int[] arr, int s) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= s) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int s = 7;
        System.out.println("Length of the smallest subarray: " + smallestSubarrayWithSum(arr, s));
    }
}
