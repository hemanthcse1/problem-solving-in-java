package examples.interviewquestions.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class SubstringXORQueries {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> valueToIndexMap = new HashMap<>();
        int n = s.length();

        for (int start = 0; start < n; start++) {
            int value = 0;
            for (int end = start; end < Math.min(start + 30, n); end++) {
                value = (value << 1) | (s.charAt(end) - '0');
                if (!valueToIndexMap.containsKey(value) || (end - start) < (valueToIndexMap.get(value)[1] - valueToIndexMap.get(value)[0])) {
                    valueToIndexMap.put(value, new int[]{start, end});
                }
            }
        }

        int[][] result = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            int targetValue = first ^ second;

            if (valueToIndexMap.containsKey(targetValue)) {
                result[i] = valueToIndexMap.get(targetValue);
            } else {
                result[i] = new int[]{-1, -1};
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringXORQueries solution = new SubstringXORQueries();

        String s1 = "101101";
        int[][] queries1 = {{0, 5}, {1, 2}};
        int[][] result1 = solution.substringXorQueries(s1, queries1);
        for (int[] res : result1) {
            System.out.print("[" + res[0] + ", " + res[1] + "] ");
        }

        System.out.println();

        String s2 = "0101";
        int[][] queries2 = {{12, 8}};
        int[][] result2 = solution.substringXorQueries(s2, queries2);
        for (int[] res : result2) {
            System.out.print("[" + res[0] + ", " + res[1] + "] ");
        }
    }
}
