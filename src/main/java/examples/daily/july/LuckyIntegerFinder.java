package examples.daily.july;

import java.util.HashMap;
import java.util.Map;

public class LuckyIntegerFinder {

    public int findLucky(int[] arr){
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num: arr){
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int luckyNumber = -1;
        for (Map.Entry<Integer, Integer> entries: frequency.entrySet()){
            int num = entries.getKey();
            int value = entries.getValue();

            if (num == value){
                luckyNumber = value;
            }
        }
        return luckyNumber;
    }

    public static void main(String[] args) {
        LuckyIntegerFinder luckyIntegerFinder = new LuckyIntegerFinder();

        int[] arr1 = {2, 2, 3, 4};
        int[] arr2 = {1, 2, 2, 3, 3, 3};
        int[] arr3 = {2, 2, 2, 3, 3};

        System.out.println("Output 1: " + luckyIntegerFinder.findLucky(arr1)); // 2
        System.out.println("Output 2: " + luckyIntegerFinder.findLucky(arr2)); // 3
        System.out.println("Output 3: " + luckyIntegerFinder.findLucky(arr3)); // -1
    }
}
