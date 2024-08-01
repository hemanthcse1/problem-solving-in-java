package examples.interviewquestions.memoization;

import java.util.*;

public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int minCost = directPurchase(price, needs);

        for (List<Integer> offer : special) {
            List<Integer> tempNeeds = applyOffer(needs, offer);
            if (tempNeeds != null) {
                minCost = Math.min(minCost, offer.get(offer.size() - 1) + dfs(price, special, tempNeeds, memo));
            }
        }

        memo.put(needs, minCost);
        return minCost;
    }

    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < price.size(); i++) {
            total += price.get(i) * needs.get(i);
        }
        return total;
    }

    private List<Integer> applyOffer(List<Integer> needs, List<Integer> offer) {
        List<Integer> newNeeds = new ArrayList<>(needs);
        for (int i = 0; i < needs.size(); i++) {
            if (offer.get(i) > needs.get(i)) {
                return null; // offer can't be applied
            }
            newNeeds.set(i, newNeeds.get(i) - offer.get(i));
        }
        return newNeeds;
    }

    public static void main(String[] args) {
        ShoppingOffers so = new ShoppingOffers();
        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> special = Arrays.asList(
                Arrays.asList(3, 0, 5),  // 3A for $5
                Arrays.asList(1, 2, 10)  // 1A + 2B for $10
        );
        List<Integer> needs = Arrays.asList(3, 2);  // 3A and 2B

        System.out.println("Lowest price: " + so.shoppingOffers(price, special, needs));
    }
}
