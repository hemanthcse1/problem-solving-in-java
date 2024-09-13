package examples.interviewquestions.strings.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int minDifference = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int difference = arr[i] - arr[i - 1];
            if (difference < minDifference) {
                minDifference = difference;
                result.clear();
            }
            if (difference == minDifference) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumAbsDifference solution = new MinimumAbsDifference();

        int[] arr1 = {4, 2, 1, 3};
        System.out.println(solution.minimumAbsDifference(arr1));

        int[] arr2 = {1, 3, 6, 10, 15};
        System.out.println(solution.minimumAbsDifference(arr2));

        int[] arr3 = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(solution.minimumAbsDifference(arr3));
    }
}
