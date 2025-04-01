package examples.daily.march;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarbleBagScoreDifferenceCalculator {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        List<Long> pairSums = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            pairSums.add((long) weights[i] + weights[i + 1]);
        }
        Collections.sort(pairSums);
        long minScore = 0, maxScore = 0;
        for (int i = 0; i < k - 1; i++) {
            minScore += pairSums.get(i);
            maxScore += pairSums.get(n - 2 - i);
        }
        return maxScore - minScore;
    }

    public static void main(String[] args) {
        MarbleBagScoreDifferenceCalculator calculator = new MarbleBagScoreDifferenceCalculator();

        int[] weights1 = {1, 3, 5, 1};
        int k1 = 2;
        System.out.println(calculator.putMarbles(weights1, k1));  //  4

        int[] weights2 = {1, 3};
        int k2 = 2;
        System.out.println(calculator.putMarbles(weights2, k2));  //  0
    }
}
