package examples.interviewquestions.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }
    public static void main(String[] args) {
        RankTransform rt = new RankTransform();

        int[] arr1 = {40, 10, 20, 30};
        System.out.println(Arrays.toString(rt.arrayRankTransform(arr1)));
    }
}
