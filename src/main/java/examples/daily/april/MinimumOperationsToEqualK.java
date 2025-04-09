package examples.daily.april;

import java.util.Arrays;
import java.util.TreeSet;

public class MinimumOperationsToEqualK {

    public int minimumOperations(int[] nums, int k) {
        if (!canReachK(nums, k)) return -1;

        TreeSet<Integer> uniqueGreater = new TreeSet<>();
        for (int num : nums) {
            if (num > k) uniqueGreater.add(num);
        }

        int operations = 0;
        while (!uniqueGreater.isEmpty()) {
            int h = uniqueGreater.last();
            uniqueGreater.remove(h);
            operations++;
        }

        if (Arrays.stream(nums).anyMatch(num -> num < k)) return -1;

        return operations;
    }

    private boolean canReachK(int[] nums, int k) {
        for (int num : nums) {
            if (num < k) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumOperationsToEqualK solver = new MinimumOperationsToEqualK();
        System.out.println(solver.minimumOperations(new int[]{5, 2, 5, 4, 5}, 2)); //  2
        System.out.println(solver.minimumOperations(new int[]{2, 1, 2}, 2)); //  -1
        System.out.println(solver.minimumOperations(new int[]{9, 7, 5, 3}, 1)); //  4
    }
}
