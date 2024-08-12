package examples.hashtables.easy;

public class BeautifulPairs {
    public static void main(String[] args) {
        int[] nums1 = {23, 19, 14, 6, 8}; // Example 1
        System.out.println("Number of beautiful pairs: " + countBeautifulPairs(nums1));

        int[] nums2 = {10, 22, 32, 41, 51}; // Example 2
        System.out.println("Number of beautiful pairs: " + countBeautifulPairs(nums2));

        int[] nums3 = {123, 456, 789}; // Example 3
        System.out.println("Number of beautiful pairs: " + countBeautifulPairs(nums3));
    }

    public static int countBeautifulPairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int firstDigit = getFirstDigit(nums[i]);

            for (int j = i + 1; j < nums.length; j++) {
                int lastDigit = getLastDigit(nums[j]);

                if (gcd(firstDigit, lastDigit) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    private static int getLastDigit(int num) {
        return num % 10;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
