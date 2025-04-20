package examples.daily.april;

import java.util.HashMap;
import java.util.Map;

public class RabbitCountEstimator {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int totalRabbits = 0;

        for (int answer : answers) {
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int answer = entry.getKey();
            int frequency = entry.getValue();
            int groupSize = answer + 1;
            int numberOfGroups = (int) Math.ceil((double) frequency / groupSize);
            totalRabbits += numberOfGroups * groupSize;
        }

        return totalRabbits;
    }

    public static void main(String[] args) {
        RabbitCountEstimator estimator = new RabbitCountEstimator();

        int[] answers1 = {1, 1, 2};
        System.out.println("Estimated rabbit count (Example 1): " + estimator.numRabbits(answers1)); // Output: 5

        int[] answers2 = {10, 10, 10};
        System.out.println("Estimated rabbit count (Example 2): " + estimator.numRabbits(answers2)); // Output: 11

        int[] answers3 = {0, 0, 1, 1, 1};
        System.out.println("Estimated rabbit count (Example 3): " + estimator.numRabbits(answers3)); // Output: 6
    }
}
