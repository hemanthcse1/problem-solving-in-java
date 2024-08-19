package examples.interviewquestions.arrays.easy;

import java.util.*;

public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int num : arr2) {
            if (frequencyMap.containsKey(num)) {
                int count = frequencyMap.get(num);
                for (int i = 0; i < count; i++) {
                    resultList.add(num);
                }
                frequencyMap.remove(num);
            }
        }
        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remaining.add(entry.getKey());
            }
        }
        Collections.sort(remaining);
        resultList.addAll(remaining);
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        int[] result = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}
