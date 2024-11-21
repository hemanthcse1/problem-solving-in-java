package examples.interviewquestions.arrays.medium;

public class ZeroArrayTransformationOne {

    public boolean canTransform(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }

        int[] decrements = new int[n];
        decrements[0] = diff[0];
        for (int i = 1; i < n; i++) {
            decrements[i] = decrements[i - 1] + diff[i];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > decrements[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ZeroArrayTransformationOne solution = new ZeroArrayTransformationOne();
        System.out.println(solution.canTransform(new int[]{1, 0, 1}, new int[][]{{0, 2}}));
        System.out.println(solution.canTransform(new int[]{4, 3, 2, 1}, new int[][]{{1, 3}, {0, 2}}));
    }

}
