package examples.daily.april;

import java.util.HashMap;
import java.util.Map;

public class DigitGroupCounterApp {

    public static void main(String[] args) {
        DigitGroupCounterApp solution = new DigitGroupCounterApp();

        int n = 24;
        int result = solution.countLargestGroup(n);

        System.out.println("Number of groups with the largest size for n = " + n + ": " + result);
    }

    public int countLargestGroup(int n) {
        Map<Integer, Integer> digitSumMap = new HashMap<>();
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            digitSumMap.put(sum, digitSumMap.getOrDefault(sum, 0) + 1);
            maxSize = Math.max(maxSize, digitSumMap.get(sum));
        }
        int count = 0;
        for (int size : digitSumMap.values()) {
            if (size == maxSize) {
                count++;
            }
        }

        return count;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }


}
