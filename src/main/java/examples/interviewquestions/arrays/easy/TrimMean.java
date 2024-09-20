package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class TrimMean {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        int removeCount = n / 20;

        int sum = 0;
        for (int i = removeCount; i < n - removeCount; i++) {
            sum += arr[i];
        }

        int remainingCount = n - 2 * removeCount;

        return (double) sum / remainingCount;
    }

    public static void main(String[] args) {
        TrimMean solution = new TrimMean();

        int[] arr1 = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        System.out.println(solution.trimMean(arr1));

        int[] arr2 = {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
        System.out.println(solution.trimMean(arr2));

        int[] arr3 = {6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4};
        System.out.println(solution.trimMean(arr3));
    }
}
