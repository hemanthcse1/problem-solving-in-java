package examples.interviewquestions.arrays.easy;

public class FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int threshold = n / 4;

        for (int i = 0; i < n; i += threshold) {
            if (countOccurrences(arr, arr[i], threshold)) {
                return arr[i];
            }
        }

        return -1;
    }

    private boolean countOccurrences(int[] arr, int target, int threshold) {
        int firstIndex = binarySearch(arr, target, true);
        int lastIndex = binarySearch(arr, target, false);

        return lastIndex - firstIndex + 1 > threshold;
    }

    private int binarySearch(int[] arr, int target, boolean findFirst) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                if (findFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindSpecialInteger solution = new FindSpecialInteger();

        int[] arr1 = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(solution.findSpecialInteger(arr1));

        int[] arr2 = {1, 1};
        System.out.println(solution.findSpecialInteger(arr2));
    }
}
