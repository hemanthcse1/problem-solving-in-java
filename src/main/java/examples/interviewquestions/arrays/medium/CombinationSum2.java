package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remainingTarget, int start) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > remainingTarget) break;

            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remainingTarget - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 solution = new CombinationSum2();

        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        List<List<Integer>> result1 = solution.combinationSum2(candidates1, target1);
        System.out.println("Combinations for target " + target1 + ": " + result1);

        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        List<List<Integer>> result2 = solution.combinationSum2(candidates2, target2);
        System.out.println("Combinations for target " + target2 + ": " + result2);
    }
}
