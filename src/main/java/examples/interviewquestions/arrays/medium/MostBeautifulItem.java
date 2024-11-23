package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class MostBeautifulItem {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int n = items.length;
        int[] maxBeauty = new int[n];
        maxBeauty[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }

        int[][] queriesWithIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }
        Arrays.sort(queriesWithIndex, (a, b) -> a[0] - b[0]);

        int[] result = new int[queries.length];
        int j = 0; // Pointer for items
        for (int[] query : queriesWithIndex) {
            int queryPrice = query[0];
            int queryIndex = query[1];

            while (j < n && items[j][0] <= queryPrice) {
                j++;
            }

            result[queryIndex] = (j > 0) ? maxBeauty[j - 1] : 0;
        }

        return result;
    }

    public static void main(String[] args) {
        MostBeautifulItem solution = new MostBeautifulItem();

        int[][] items1 = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries1 = {1, 2, 3, 4, 5, 6};
        int[] result1 = solution.maximumBeauty(items1, queries1);
        System.out.println("Example 1 Output: " + Arrays.toString(result1));

        int[][] items2 = {{1, 2}, {1, 2}, {1, 3}, {1, 4}};
        int[] queries2 = {1};
        int[] result2 = solution.maximumBeauty(items2, queries2);
        System.out.println("Example 2 Output: " + Arrays.toString(result2));

        int[][] items3 = {{10, 1000}};
        int[] queries3 = {5};
        int[] result3 = solution.maximumBeauty(items3, queries3);
        System.out.println("Example 3 Output: " + Arrays.toString(result3));
    }
}
