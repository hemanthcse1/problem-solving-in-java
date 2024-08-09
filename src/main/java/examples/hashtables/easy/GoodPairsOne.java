package examples.hashtables.easy;

public class GoodPairsOne {
    public static int findNumberOfGoodPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        int n = nums1.length;
        int m = nums2.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] % (nums2[j] * k) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 12, 15, 25};
        int[] nums2 = {2, 5};
        int k = 2;

        int result = findNumberOfGoodPairs(nums1, nums2, k);
        System.out.println("Number of good pairs: " + result);
    }
}
