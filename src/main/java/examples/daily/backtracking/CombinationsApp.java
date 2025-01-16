package examples.daily.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationsApp {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(1, 1));
        System.out.println(combine(5, 3));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            current.add(i);
            backtrack(result, current, i + 1, n, k - 1);
            current.remove(current.size() - 1);
        }
    }
}
