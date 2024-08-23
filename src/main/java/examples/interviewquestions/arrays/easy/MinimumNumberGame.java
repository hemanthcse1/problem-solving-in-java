package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberGame {
    public int[] playGame(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        while (!numsList.isEmpty()) {
            int minIndexAlice = findMinIndex(numsList);
            int aliceValue = numsList.remove(minIndexAlice);
            int minIndexBob = findMinIndex(numsList);
            int bobValue = numsList.remove(minIndexBob);

            arr.add(bobValue);
            arr.add(aliceValue);
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    private int findMinIndex(List<Integer> numsList) {
        int minIndex = 0;
        for (int i = 1; i < numsList.size(); i++) {
            if (numsList.get(i) < numsList.get(minIndex)) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        MinimumNumberGame game = new MinimumNumberGame();
        int[] nums = {3, 1, 2, 4};
        int[] result = game.playGame(nums);
        System.out.println("Resulting array: " + Arrays.toString(result));
    }
}
