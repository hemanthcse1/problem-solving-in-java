package examples.daily.march;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSplit {

    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.size();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int dominant = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() * 2 > n) {
                dominant = entry.getKey();
                break;
            }
        }

        int leftCount = 0;
        int totalCount = freq.get(dominant);

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }
            int leftSize = i + 1;
            int rightSize = n - leftSize;
            if (leftCount * 2 > leftSize && (totalCount - leftCount) * 2 > rightSize) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumIndexSplit solver = new MinimumIndexSplit();

        System.out.println(solver.minimumIndex(toList(new int[]{1, 2, 2, 2})));             // 2
        System.out.println(solver.minimumIndex(toList(new int[]{2, 1, 3, 1, 1, 1, 7, 1, 2, 1}))); // 4
        System.out.println(solver.minimumIndex(toList(new int[]{3, 3, 3, 3, 7, 2, 2})));     // -1
    }

    public static List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}
