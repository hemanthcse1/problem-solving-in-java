package examples;

import java.util.Arrays;

public class DefuseBomb {

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            Arrays.fill(result, 0);
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
                result[i] = sum;
            } else if (k < 0) {
                int sum = 0;
                for (int j = -1; j >= k; j--) {
                    sum += code[(i + j + n) % n];
                }
                result[i] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DefuseBomb solution = new DefuseBomb();

        int[] code1 = {5, 7, 1, 4};
        int k1 = 3;
        int[] result1 = solution.decrypt(code1, k1);
        System.out.println("Input: code = " + Arrays.toString(code1) + ", k = " + k1);
        System.out.println("Output: " + Arrays.toString(result1));


        int[] code2 = {1, 2, 3, 4};
        int k2 = 0;
        int[] result2 = solution.decrypt(code2, k2);
        System.out.println("Input: code = " + Arrays.toString(code2) + ", k = " + k2);
        System.out.println("Output: " + Arrays.toString(result2));

        int[] code3 = {2, 4, 9, 3};
        int k3 = -2;
        int[] result3 = solution.decrypt(code3, k3);
        System.out.println("Input: code = " + Arrays.toString(code3) + ", k = " + k3);
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
