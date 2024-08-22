package examples.interviewquestions.arrays.easy;

public class ValidMountainArray {
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int i = 0;
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) {
            return false;
        }
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == n - 1;
    }

    public static void main(String[] args) {

        int[] arr1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        System.out.println(validMountainArray(arr1));
    }
}
