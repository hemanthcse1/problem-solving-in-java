package examples.interviewquestions.dynamicprogramming.medium;

public class BestTimeToBuyAndSellStockWithTransactionFeeSolution {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;

        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < n; i++) {

            cash = Math.max(cash, hold + prices[i] - fee);

            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFeeSolution solution = new BestTimeToBuyAndSellStockWithTransactionFeeSolution();

        int[] prices1 = {1, 3, 2, 8, 4, 9};
        int fee1 = 2;
        System.out.println("Maximum Profit for prices [1,3,2,8,4,9] with fee = 2: " + solution.maxProfit(prices1, fee1));


        int[] prices2 = {1, 3, 7, 5, 10, 3};
        int fee2 = 3;
        System.out.println("Maximum Profit for prices [1,3,7,5,10,3] with fee = 3: " + solution.maxProfit(prices2, fee2));
    }
}
