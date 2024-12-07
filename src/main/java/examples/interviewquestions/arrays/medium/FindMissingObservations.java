package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = (n + m) * mean;
        int sumRolls = 0;

        for (int roll : rolls) {
            sumRolls += roll;
        }

        int missingSum = totalSum - sumRolls;

        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }

        int[] result = new int[n];
        Arrays.fill(result, 1);
        missingSum -= n;

        for (int i = 0; i < n && missingSum > 0; i++) {
            int increment = Math.min(5, missingSum);
            result[i] += increment;
            missingSum -= increment;
        }

        return result;
    }

    public static void main(String[] args) {
        FindMissingObservations solution = new FindMissingObservations();

        int[] rolls1 = {3, 2, 4, 3};
        int mean1 = 4, n1 = 2;
        System.out.println(Arrays.toString(solution.missingRolls(rolls1, mean1, n1)));

        int[] rolls2 = {1, 5, 6};
        int mean2 = 3, n2 = 4;
        System.out.println(Arrays.toString(solution.missingRolls(rolls2, mean2, n2)));
    }
}
