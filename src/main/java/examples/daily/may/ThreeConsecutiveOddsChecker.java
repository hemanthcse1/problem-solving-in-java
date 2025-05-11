package examples.daily.may;

public class ThreeConsecutiveOddsChecker {

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreeConsecutiveOddsChecker checker = new ThreeConsecutiveOddsChecker();

        int[] arr1 = {2, 6, 4, 1}; // false
        int[] arr2 = {1, 2, 34, 3, 4, 5, 7, 23, 12}; // true

        System.out.println(checker.threeConsecutiveOdds(arr1));
        System.out.println(checker.threeConsecutiveOdds(arr2));
    }
}
