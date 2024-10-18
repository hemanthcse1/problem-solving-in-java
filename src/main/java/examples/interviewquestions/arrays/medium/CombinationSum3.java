package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int target, int start) {
        if (combination.size() == k && target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (combination.size() > k || target < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            combination.add(i);

            backtrack(result, combination, k, target - i, i + 1);

            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 solution = new CombinationSum3();

        System.out.println("Example 1: " + solution.combinationSum3(3, 7));

        System.out.println("Example 2: " + solution.combinationSum3(3, 9));

        System.out.println("Example 3: " + solution.combinationSum3(4, 1));
    }
}
