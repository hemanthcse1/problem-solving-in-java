package examples.daily;

public class MaxBeautifyOfAnArray {

    public static int maximumBeauty(int[] nums, int k) {
        int n = nums.length;

        int SHIFT = 100000;

        int MAX_RANGE = 300001;
        int[] diff = new int[MAX_RANGE];

        for (int num : nums) {
            int start = Math.max(0, num - k + SHIFT);
            int end = Math.min(MAX_RANGE - 1, num + k + SHIFT);
            diff[start]++;
            if (end + 1 < MAX_RANGE) diff[end + 1]--;
        }

        int maxOverlap = 0;
        int current = 0;
        for (int i = 0; i < MAX_RANGE; i++) {
            current += diff[i];
            if (current > maxOverlap) {
                maxOverlap = current;
            }
        }

        return maxOverlap;
    }

    public static void main(String[] args) {
        System.out.println(maximumBeauty(new int[]{4,6,1,2}, 2));
        System.out.println(maximumBeauty(new int[]{1,1,1,1}, 10));
    }
}
