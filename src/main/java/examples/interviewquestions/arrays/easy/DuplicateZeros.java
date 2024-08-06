package examples.interviewquestions.arrays.easy;

public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zerosCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zerosCount++;
            }
        }
        int i = n - 1;
        int j = n + zerosCount - 1;
        while (i < j) {
            if (j < n) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }i--;j--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        System.out.println("Array after duplicating zeros: "
                + java.util.Arrays.toString(arr));
    }
}
