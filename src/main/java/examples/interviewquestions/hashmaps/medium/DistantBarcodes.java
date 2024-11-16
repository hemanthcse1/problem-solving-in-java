package examples.interviewquestions.hashmaps.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int barcode : barcodes) {
            countMap.put(barcode, countMap.getOrDefault(barcode, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            heap.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] result = new int[barcodes.length];
        int index = 0;

        while (!heap.isEmpty()) {
            int[] first = heap.poll();
            if (index > 0 && result[index - 1] == first[0]) {
                int[] second = heap.poll();
                result[index++] = second[0];
                second[1]--;
                if (second[1] > 0) {
                    heap.add(second);
                }
                heap.add(first);
            } else {
                result[index++] = first[0];
                first[1]--;
                if (first[1] > 0) {
                    heap.add(first);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DistantBarcodes sol = new DistantBarcodes();
        int[] barcodes1 = {1, 1, 1, 2, 2, 2};
        System.out.println(Arrays.toString(sol.rearrangeBarcodes(barcodes1)));

        int[] barcodes2 = {1, 1, 1, 1, 2, 2, 3, 3};
        System.out.println(Arrays.toString(sol.rearrangeBarcodes(barcodes2)));
    }
}
