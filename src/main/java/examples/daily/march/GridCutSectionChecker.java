package examples.daily.march;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GridCutSectionChecker {

    public boolean canBeCut(int n, int[][] rectangles) {
        return checkCutPossible(rectangles, true) || checkCutPossible(rectangles, false);
    }

    private boolean checkCutPossible(int[][] rectangles, boolean isVertical) {
        List<int[]> intervals = new ArrayList<>();
        for (int[] rect : rectangles) {
            int start = isVertical ? rect[0] : rect[1];
            int end = isVertical ? rect[2] : rect[3];
            intervals.add(new int[]{start, end});
        }

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        int n = intervals.size();
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = intervals.get(0)[1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], intervals.get(i)[1]);
        }

        suffixMin[n - 1] = intervals.get(n - 1)[0];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], intervals.get(i)[0]);
        }

        List<Integer> cutCandidates = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (prefixMax[i] <= suffixMin[i + 1]) {
                cutCandidates.add(i);
            }
        }

        if (cutCandidates.size() < 2) return false;

        for (int i = 0; i < cutCandidates.size(); i++) {
            for (int j = i + 1; j < cutCandidates.size(); j++) {
                int first = cutCandidates.get(i);
                int second = cutCandidates.get(j);

                boolean[] hasSection = new boolean[3];
                for (int k = 0; k < n; k++) {
                    if (k <= first) hasSection[0] = true;
                    else if (k <= second) hasSection[1] = true;
                    else hasSection[2] = true;
                }

                if (hasSection[0] && hasSection[1] && hasSection[2]) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        GridCutSectionChecker checker = new GridCutSectionChecker();

        int n1 = 5;
        int[][] rectangles1 = {{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}};
        System.out.println(checker.canBeCut(n1, rectangles1)); // true

        int n2 = 4;
        int[][] rectangles2 = {{0, 0, 1, 1}, {2, 0, 3, 4}, {0, 2, 2, 3}, {3, 0, 4, 3}};
        System.out.println(checker.canBeCut(n2, rectangles2)); // true

        int n3 = 4;
        int[][] rectangles3 = {{0, 2, 2, 4}, {1, 0, 3, 2}, {2, 2, 3, 4}, {3, 0, 4, 2}, {3, 2, 4, 4}};
        System.out.println(checker.canBeCut(n3, rectangles3)); // false
    }
}
