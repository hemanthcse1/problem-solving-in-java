package examples.daily.june;

import java.util.*;

public class MaxDifferenceCalculator {
    public int maxDifference(String s, int k) {
        int maxDiff = Integer.MIN_VALUE;

        for (Map.Entry<Character, Character> pair : getCharPermutations()) {
            char a = pair.getKey();
            char b = pair.getValue();

            int[][] minDiff = new int[2][2];
            for (int[] arr : minDiff) Arrays.fill(arr, Integer.MAX_VALUE / 2);

            List<Integer> prefixA = new ArrayList<>(Collections.singletonList(0));
            List<Integer> prefixB = new ArrayList<>(Collections.singletonList(0));

            for (int left = 0, right = 0; right < s.length(); ++right) {
                prefixA.add(prefixA.get(prefixA.size() - 1) + (s.charAt(right) == a ? 1 : 0));
                prefixB.add(prefixB.get(prefixB.size() - 1) + (s.charAt(right) == b ? 1 : 0));

                while (right - left + 1 >= k
                        && prefixA.get(left) < prefixA.get(prefixA.size() - 1)
                        && prefixB.get(left) < prefixB.get(prefixB.size() - 1)) {
                    int parityA = prefixA.get(left) % 2;
                    int parityB = prefixB.get(left) % 2;
                    minDiff[parityA][parityB] = Math.min(minDiff[parityA][parityB],
                            prefixA.get(left) - prefixB.get(left));
                    ++left;
                }

                int curA = prefixA.get(prefixA.size() - 1);
                int curB = prefixB.get(prefixB.size() - 1);
                int parityA = curA % 2;
                int parityB = curB % 2;
                maxDiff = Math.max(maxDiff, (curA - curB) - minDiff[1 - parityA][parityB]);
            }
        }
        return maxDiff;
    }

    private List<Map.Entry<Character, Character>> getCharPermutations() {
        List<Map.Entry<Character, Character>> permutations = new ArrayList<>();
        char[] chars = "01234".toCharArray();
        for (char a : chars) {
            for (char b : chars) {
                if (a != b) {
                    permutations.add(Map.entry(a, b));
                }
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        MaxDifferenceCalculator calculator = new MaxDifferenceCalculator();

        String s = "0123401234";
        int k = 3;

        int result = calculator.maxDifference(s, k);
        System.out.println("Maximum difference: " + result);
    }
}
