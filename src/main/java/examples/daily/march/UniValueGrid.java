package examples.daily.march;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniValueGrid {

    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        for (int[] row : grid) {
            for (int val : row) {
                nums.add(val);
            }
        }

        int mod = nums.get(0) % x;
        for (int num : nums) {
            if (num % x != mod) {
                return -1;
            }
        }

        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);

        int operations = 0;
        for (int num : nums) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }

    public static void main(String[] args) {
        UniValueGrid solver = new UniValueGrid();
        System.out.println(solver.minOperations(new int[][]{{2, 4}, {6, 8}}, 2));
        System.out.println(solver.minOperations(new int[][]{{1, 5}, {2, 3}}, 1));
        System.out.println(solver.minOperations(new int[][]{{1, 2}, {3, 4}}, 2));
    }
}
