package examples.daily.medium.january;

public class BitwiseXorOfAllPairingsApp {

    public static void main(String[] args) {
        int[] nums1a = {2, 1, 3};
        int[] nums2a = {10, 2, 5, 0};
        System.out.println(bitwiseXorOfAllPairings(nums1a, nums2a));

        int[] nums1b = {1, 2};
        int[] nums2b = {3, 4};
        System.out.println(bitwiseXorOfAllPairings(nums1b, nums2b));

        int[] nums1c = {0};
        int[] nums2c = {0};
        System.out.println(bitwiseXorOfAllPairings(nums1c, nums2c));

        int[] nums1d = {5, 5, 5};
        int[] nums2d = {1};
        System.out.println(bitwiseXorOfAllPairings(nums1d, nums2d));
    }

    public static int bitwiseXorOfAllPairings(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;
        for (int num : nums1) xor1 ^= num;
        for (int num : nums2) xor2 ^= num;

        int result = 0;
        if ((nums2.length & 1) == 1) result ^= xor1;
        if ((nums1.length & 1) == 1) result ^= xor2;
        return result;
    }
}
