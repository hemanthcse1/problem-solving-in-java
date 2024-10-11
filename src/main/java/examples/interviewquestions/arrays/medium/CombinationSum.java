package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remainingTarget, int start) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        if (remainingTarget < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remainingTarget - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();

        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Combinations for target " + target1 + ": " + solution.combinationSum(candidates1, target1));

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Combinations for target " + target2 + ": " + solution.combinationSum(candidates2, target2));

        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println("Combinations for target " + target3 + ": " + solution.combinationSum(candidates3, target3));
    }
}
