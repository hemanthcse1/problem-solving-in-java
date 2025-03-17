package examples.daily.march;

public class DivideArrayIntoEqualPairs {
    public static boolean canDivideIntoPairs(int[] nums) {
        int[] frequency = new int[501];

        for (int num : nums) {
            frequency[num]++;
        }

        for (int count : frequency) {
            if (count % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3, 2, 2, 2};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println("Can nums1 be divided into equal pairs? : " + canDivideIntoPairs(nums1)); // true
        System.out.println("Can nums2 be divided into equal pairs? : " + canDivideIntoPairs(nums2)); // false
    }
}
