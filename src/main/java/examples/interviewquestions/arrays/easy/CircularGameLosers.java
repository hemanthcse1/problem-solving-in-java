package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularGameLosers {
    public int[] circularGameLosers(int n, int k) {
        boolean[] received = new boolean[n];
        int currentPosition = 0;
        int steps = 1;

        received[currentPosition] = true;

        while (true) {
            currentPosition = (currentPosition + steps * k) % n;

            if (received[currentPosition]) {
                break;
            }

            received[currentPosition] = true;

            steps++;
        }

        List<Integer> losers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!received[i]) {
                losers.add(i + 1);
            }
        }

        int[] result = new int[losers.size()];
        for (int i = 0; i < losers.size(); i++) {
            result[i] = losers.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        CircularGameLosers solution = new CircularGameLosers();

        int n1 = 5, k1 = 2;
        System.out.println(Arrays.toString(solution.circularGameLosers(n1, k1)));

        int n2 = 4, k2 = 4;
        System.out.println(Arrays.toString(solution.circularGameLosers(n2, k2)));
    }
}
