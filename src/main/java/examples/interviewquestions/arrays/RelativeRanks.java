package examples.interviewquestions.arrays;

import java.util.Arrays;

public class RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        Integer[] indices = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> score[b] - score[a]);

        String[] result = new String[score.length];

        for (int i = 0; i < indices.length; i++) {
            if (i == 0) {
                result[indices[i]] = "Gold Medal";
            } else if (i == 1) {
                result[indices[i]] = "Silver Medal";
            } else if (i == 2) {
                result[indices[i]] = "Bronze Medal";
            } else {
                result[indices[i]] = String.valueOf(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] scores1 = {5, 4, 3, 2, 1};
        int[] scores2 = {10, 3, 8, 9, 4};

        System.out.println(Arrays.toString(findRelativeRanks(scores1)));
        System.out.println(Arrays.toString(findRelativeRanks(scores2)));
    }
}
