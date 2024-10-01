package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class KWeakestRows {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[][] soldierCount = new int[mat.length][2];

        for (int i = 0; i < mat.length; i++) {
            int count = countSoldiers(mat[i]);
            soldierCount[i][0] = count;
            soldierCount[i][1] = i;
        }

        Arrays.sort(soldierCount, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = soldierCount[i][1];
        }

        return result;
    }

    private static int countSoldiers(int[] row) {
        int count = 0;
        for (int val : row) {
            if (val == 1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k1 = 3;
        System.out.println(Arrays.toString(kWeakestRows(mat1, k1)));

        int[][] mat2 = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };
        int k2 = 2;
        System.out.println(Arrays.toString(kWeakestRows(mat2, k2)));
    }
}

