package examples.daily.february;

import java.util.Arrays;

public class LargestValidSequence {
    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        int[] res = new int[size];
        boolean[] used = new boolean[n + 1];
        backtrack(res, used, 0, n);
        return res;
    }

    private boolean backtrack(int[] res, boolean[] used, int index, int n) {
        while (index < res.length && res[index] != 0) {
            index++;
        }


        if (index == res.length) return true;


        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;


            if (num == 1 || (index + num < res.length && res[index + num] == 0)) {
                res[index] = num;
                if (num > 1) res[index + num] = num;
                used[num] = true;


                if (backtrack(res, used, index + 1, n)) return true;


                res[index] = 0;
                if (num > 1) res[index + num] = 0;
                used[num] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LargestValidSequence solution = new LargestValidSequence();
        System.out.println(Arrays.toString(solution.constructDistancedSequence(3)));
        System.out.println(Arrays.toString(solution.constructDistancedSequence(5)));
    }
}
