package examples.interviewquestions.arrays.easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = false;
        boolean decreasing = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                increasing = true;
            }
            if (nums[i] > nums[i + 1]) {
                decreasing = true;
            }
            if (increasing && decreasing) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MonotonicArray solver = new MonotonicArray();
        System.out.println(solver.isMonotonic(new int[]{1,2,2,3}));
        System.out.println(solver.isMonotonic(new int[]{6,5,4,4}));
        System.out.println(solver.isMonotonic(new int[]{1,3,2}));
    }
}
