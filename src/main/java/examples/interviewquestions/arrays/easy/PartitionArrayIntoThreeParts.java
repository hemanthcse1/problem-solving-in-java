package examples.interviewquestions.arrays.easy;

public class PartitionArrayIntoThreeParts {
    public static boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 3 != 0) {
            return false;
        }

        int target = totalSum / 3;
        int currentSum = 0;
        int count = 0;

        for (int num : arr) {
            currentSum += num;

            if (currentSum == target) {
                count++;
                currentSum = 0;
            }

            if (count == 3) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(canThreePartsEqualSum(arr1));

        int[] arr2 = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
        System.out.println(canThreePartsEqualSum(arr2));

        int[] arr3 = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        System.out.println(canThreePartsEqualSum(arr3));
    }
}
