package examples.interviewquestions.arrays;

import java.util.*;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }

        result.sort(Comparator.comparingInt(a -> a.get(0)));

        return result;
    }

    public static void main(String[] args) {
        MergeSimilarItems solution = new MergeSimilarItems();
        int[][] items1 = {{1, 3}, {2, 2}, {3, 1}};
        int[][] items2 = {{1, 2}, {3, 2}, {4, 1}};

        List<List<Integer>> mergedItems = solution.mergeSimilarItems(items1, items2);
        for (List<Integer> item : mergedItems) {
            System.out.println(item);
        }
    }
}
