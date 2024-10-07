package examples.interviewquestions.arrays.easy;

public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        int minPossibleScore = (max - k) - (min + k);
        return Math.max(0, minPossibleScore);
    }

    public static void main(String[] args) {
        SmallestRangeI solver = new SmallestRangeI();
        System.out.println(solver.smallestRangeI(new int[]{1}, 0));
        System.out.println(solver.smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(solver.smallestRangeI(new int[]{1, 3, 6}, 3));
    }
}
