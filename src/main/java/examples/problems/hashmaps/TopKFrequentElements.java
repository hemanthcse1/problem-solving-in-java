package examples.problems.hashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> countMap.get(n1) - countMap.get(n2)
        );

        for (int num : countMap.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }

        return top;
    }

    public static void main(String[] args) {
        TopKFrequentElements tkfe = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = tkfe.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
