package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class UniqueSumZero {
    public static int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;

        for (int i = 1; i <= n / 2; i++) {
            result[index++] = i;
            result[index++] = -i;
        }

        if (n % 2 == 1) {
            result[index] = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
        System.out.println(Arrays.toString(sumZero(3)));
        System.out.println(Arrays.toString(sumZero(1)));
    }
}
