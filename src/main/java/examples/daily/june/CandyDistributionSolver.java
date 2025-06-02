package examples.daily.june;

public class CandyDistributionSolver {
    public static void main(String[] args) {
        CandyDistributionSolver solution = new CandyDistributionSolver();

        int[] ratings = {1, 0, 2};
        int totalCandies = solution.candy(ratings);

        System.out.println("Total candies needed: " + totalCandies);
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }
}
