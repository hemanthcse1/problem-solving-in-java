package examples.interviewquestions.arrays.medium;

public class LargestCombination {
    public int largestCombination(int[] candidates) {
        int[] bitCounts = new int[24];
        int maxCombination = 0;

        for (int num : candidates) {
            for (int i = 0; i < 24; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCounts[i]++;
                    maxCombination = Math.max(maxCombination, bitCounts[i]);
                }
            }
        }

        return maxCombination;
    }

    public static void main(String[] args) {
        LargestCombination solution = new LargestCombination();
        System.out.println(solution.largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
        System.out.println(solution.largestCombination(new int[]{8, 8}));
    }
}
