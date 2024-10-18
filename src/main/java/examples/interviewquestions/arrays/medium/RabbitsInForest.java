package examples.interviewquestions.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
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
        RabbitsInForest solution = new RabbitsInForest();

        int[] answers1 = {1, 1, 2};
        System.out.println("Minimum rabbits: " + solution.numRabbits(answers1));

        int[] answers2 = {10, 10, 10};
        System.out.println("Minimum rabbits: " + solution.numRabbits(answers2));
    }
}
