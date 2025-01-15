package examples.daily.medium.january;

import java.util.Scanner;

public class MinimizeXorApp {
    public static void main(String[] args) {
        int[][] testData = {
                {3, 5},
                {1, 12},
                {7, 8},
                {1024, 15},
                {31, 1},
                {10, 10}
        };
        for (int[] data : testData) {
            int result = minimizeXor(data[0], data[1]);
            System.out.println("num1: " + data[0] + ", num2: " + data[1] + " => " + result);
        }
    }

    static int minimizeXor(int num1, int num2) {
        int c = Integer.bitCount(num2);
        int x = 0;
        for (int i = 31; i >= 0; i--) {
            if (((num1 >> i) & 1) == 1 && c > 0) {
                x |= (1 << i);
                c--;
            }
        }
        for (int i = 0; i <= 31 && c > 0; i++) {
            if (((num1 >> i) & 1) == 0) {
                x |= (1 << i);
                c--;
            }
        }
        return x;
    }
}
