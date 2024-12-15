package examples.interviewquestions.strings.medium;

import java.util.Arrays;

public class ShiftDistanceBetweenTwoStrings {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        int n = s.length();
        long totalCost = 0;

        for (int i = 0; i < n; i++) {
            int start = s.charAt(i) - 'a';
            int end = t.charAt(i) - 'a';

            if (start == end) continue;

            int forwardDist;
            int backwardDist;
            if (end >= start) {
                forwardDist = end - start;
                backwardDist = 26 - forwardDist;
            } else {
                backwardDist = start - end;
                forwardDist = 26 - backwardDist;
            }

            long forwardCost = 0;
            int current = start;
            for (int step = 0; step < forwardDist; step++) {
                forwardCost += nextCost[current];
                current = (current + 1) % 26;
            }

            long backwardCost = 0;
            current = start;
            for (int step = 0; step < backwardDist; step++) {
                backwardCost += previousCost[current];
                current = (current - 1 + 26) % 26;
            }

            totalCost += Math.min(forwardCost, backwardCost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        ShiftDistanceBetweenTwoStrings solver = new ShiftDistanceBetweenTwoStrings();

        String s1 = "abab", t1 = "baba";
        int[] nextCost1 = {100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] previousCost1 = {1,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(solver.shiftDistance(s1, t1, nextCost1, previousCost1));

        String s2 = "leet", t2 = "code";
        int[] nextCost2 = new int[26];
        int[] previousCost2 = new int[26];
        Arrays.fill(nextCost2, 1);
        Arrays.fill(previousCost2, 1);
        System.out.println(solver.shiftDistance(s2, t2, nextCost2, previousCost2));
    }
}
