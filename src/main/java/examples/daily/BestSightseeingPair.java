package examples.daily;

public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {
        int maxSoFar = values[0] + 0;
        int maxScore = Integer.MIN_VALUE;

        for (int j = 1; j < values.length; j++) {
            int currentScore = maxSoFar + values[j] - j;
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
            maxSoFar = Math.max(maxSoFar, values[j] + j);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        BestSightseeingPair bsp = new BestSightseeingPair();

        int[] values1 = {8, 1, 5, 2, 6};
        System.out.println("Maximum Score (Example 1): " + bsp.maxScoreSightseeingPair(values1));

        int[] values2 = {1, 2};
        System.out.println("Maximum Score (Example 2): " + bsp.maxScoreSightseeingPair(values2));
    }
}
