package examples.interviewquestions.arrays.medium;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for prices1: " + solution.maxProfit(prices1));

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Max profit for prices2: " + solution.maxProfit(prices2));

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Max profit for prices3: " + solution.maxProfit(prices3));
    }
}
