package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class BuyTwoChocolates {

    public static int buyChocolates(int[] prices, int money) {
        Arrays.sort(prices);

        int sumOfTwoCheapest = prices[0] + prices[1];

        if (sumOfTwoCheapest <= money) {
            return money - sumOfTwoCheapest;
        }

        return money;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 5, 1};
        int money = 6;

        int result = buyChocolates(prices, money);
        System.out.println("Leftover money: " + result);
    }
}
