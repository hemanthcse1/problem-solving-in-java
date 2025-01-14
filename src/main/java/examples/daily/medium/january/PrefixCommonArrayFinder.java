package examples.daily.medium.january;

import java.util.Arrays;

public class PrefixCommonArrayFinder {
    public int[] findPrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];
        int commonCount = 0;
        int[] C = new int[n];
        for (int i = 0; i < n; i++) {
            if (!seenA[A[i]]) {
                seenA[A[i]] = true;
                if (seenB[A[i]]) {
                    commonCount++;
                }
            }
            if (!seenB[B[i]]) {
                seenB[B[i]] = true;
                if (seenA[B[i]]) {
                    commonCount++;
                }
            }
            C[i] = commonCount;
        }
        return C;
    }

    public static void main(String[] args) {
        PrefixCommonArrayFinder solver = new PrefixCommonArrayFinder();

        int[] A1 = {1, 3, 2, 4};
        int[] B1 = {3, 1, 2, 4};
        int[] result1 = solver.findPrefixCommonArray(A1, B1);
        System.out.println(Arrays.toString(result1));

        int[] A2 = {2, 3, 1};
        int[] B2 = {3, 1, 2};
        int[] result2 = solver.findPrefixCommonArray(A2, B2);
        System.out.println(Arrays.toString(result2));
    }
}
