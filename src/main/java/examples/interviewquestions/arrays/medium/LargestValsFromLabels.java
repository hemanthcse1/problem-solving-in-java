package examples.interviewquestions.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestValsFromLabels {

    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] items = new int[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }

        Arrays.sort(items, (a, b) -> b[0] - a[0]);

        Map<Integer, Integer> count = new HashMap<>();
        int totalValue = 0;
        int chosen = 0;

        for (int[] item : items) {
            if (chosen == numWanted) break;
            int label = item[1];
            int c = count.getOrDefault(label, 0);
            if (c < useLimit) {
                totalValue += item[0];
                count.put(label, c+1);
                chosen++;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {

        int[] values1 = {5,4,3,2,1}, labels1 = {1,1,2,2,3};
        System.out.println(largestValsFromLabels(values1, labels1, 3, 1));

        int[] values2 = {5,4,3,2,1}, labels2 = {1,3,3,3,2};
        System.out.println(largestValsFromLabels(values2, labels2, 3, 2));
    }
}
