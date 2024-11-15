package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentPrime {

    private static final int[][] DIRECTIONS = {
            {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
    };

    public static int mostFrequentPrime(int[][] mat) {
        Map<Integer, Integer> primeFrequency = new HashMap<>();

        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : DIRECTIONS) {
                    generateNumbers(mat, i, j, dir[0], dir[1], primeFrequency);
                }
            }
        }

        int result = -1;
        int maxFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : primeFrequency.entrySet()) {
            int prime = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > maxFrequency || (frequency == maxFrequency && prime > result)) {
                maxFrequency = frequency;
                result = prime;
            }
        }

        return result;
    }

    private static void generateNumbers(int[][] mat, int x, int y, int dx, int dy, Map<Integer, Integer> primeFrequency) {
        int num = 0;
        int m = mat.length;
        int n = mat[0].length;

        while (x >= 0 && x < m && y >= 0 && y < n) {
            num = num * 10 + mat[x][y];
            if (num > 10 && isPrime(num)) {
                primeFrequency.put(num, primeFrequency.getOrDefault(num, 0) + 1);
            }
            x += dx;
            y += dy;
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1, 1}, {9, 9}, {1, 1}};
        System.out.println(mostFrequentPrime(mat1));


    }
}
