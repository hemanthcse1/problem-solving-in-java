package examples.hashtables.easy;

import java.util.HashMap;
import java.util.Map;

public class KthDistinctString {
    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : arr) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }

        int distinctCount = 0;
        for (String s : arr) {
            if (countMap.get(s) == 1) {
                distinctCount++;
                if (distinctCount == k) {
                    return s;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "a", "c", "b", "d", "e"};
        int k = 3;
        String result = kthDistinct(arr, k);
        System.out.println("The " + k + "-th distinct string is: " + result);
    }
}
