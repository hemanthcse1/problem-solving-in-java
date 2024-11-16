package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> basket = new HashMap<>();
        int maxFruits = 0, start = 0;

        for (int end = 0; end < fruits.length; end++) {
            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);

            while (basket.size() > 2) {
                basket.put(fruits[start], basket.get(fruits[start]) - 1);
                if (basket.get(fruits[start]) == 0) {
                    basket.remove(fruits[start]);
                }
                start++;
            }

            maxFruits = Math.max(maxFruits, end - start + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        FruitIntoBaskets sol = new FruitIntoBaskets();
        System.out.println(sol.totalFruit(new int[]{1, 2, 1}));
        System.out.println(sol.totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(sol.totalFruit(new int[]{1, 2, 3, 2, 2}));
    }
}
