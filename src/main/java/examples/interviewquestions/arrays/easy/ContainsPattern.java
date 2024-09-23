package examples.interviewquestions.arrays.easy;

public class ContainsPattern {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;

        for (int i = 0; i <= n - m * k; i++) {
            boolean foundPattern = true;

            for (int j = 0; j < m * (k - 1); j++) {
                if (arr[i + j] != arr[i + j + m]) {
                    foundPattern = false;
                    break;
                }
            }

            if (foundPattern) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsPattern solution = new ContainsPattern();

        int[] arr1 = {1, 2, 4, 4, 4, 4};
        System.out.println(solution.containsPattern(arr1, 1, 3));

        int[] arr2 = {1, 2, 1, 2, 1, 1, 1, 3};
        System.out.println(solution.containsPattern(arr2, 2, 2));

        int[] arr3 = {1, 2, 1, 2, 1, 3};
        System.out.println(solution.containsPattern(arr3, 2, 3));
    }
}
