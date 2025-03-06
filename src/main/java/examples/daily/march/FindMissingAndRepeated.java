package examples.daily.march;

import java.util.Arrays;

public class FindMissingAndRepeated {

    public int[] findMissingAndRepeated(int[][] grid) {
        int n = grid.length;
        int N = n * n;

        long S_expected = (long) N * (N + 1) / 2;
        long S2_expected = (long) N * (N + 1) * (2 * N + 1) / 6;


        long S_actual = 0, S2_actual = 0;
        int repeated = -1;


        int[] freq = new int[N + 1];

        for (int[] row : grid) {
            for (int num : row) {
                S_actual += num;
                S2_actual += (long) num * num;
                freq[num]++;
                if (freq[num] == 2) repeated = num;
            }
        }

        long diff = S_actual - S_expected;
        long sum = (S2_actual - S2_expected) / diff;
        int missing = (int) ((sum - diff) / 2);

        return new int[]{repeated, missing};
    }

    public static void main(String[] args) {
        FindMissingAndRepeated solver = new FindMissingAndRepeated();
        int[][] grid1 = {{1, 3}, {2, 2}};
        int[][] grid2 = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};

        System.out.println(Arrays.toString(solver.findMissingAndRepeated(grid1))); //  [2, 4]
        System.out.println(Arrays.toString(solver.findMissingAndRepeated(grid2))); //  [9, 5]
    }
}
