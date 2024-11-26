package examples.interviewquestions.strings.medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSplits {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int index, Set<String> seen) {
        if (index == s.length()) {
            return 0;
        }

        int maxCount = 0;
        for (int i = index + 1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (!seen.contains(substring)) {
                seen.add(substring);
                maxCount = Math.max(maxCount, 1 + backtrack(s, i, seen));
                seen.remove(substring);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        MaximumUniqueSplits solver = new MaximumUniqueSplits();

        String s1 = "ababccc";
        System.out.println(solver.maxUniqueSplit(s1));

        String s2 = "aba";
        System.out.println(solver.maxUniqueSplit(s2));

        String s3 = "aa";
        System.out.println(solver.maxUniqueSplit(s3));
    }
}
