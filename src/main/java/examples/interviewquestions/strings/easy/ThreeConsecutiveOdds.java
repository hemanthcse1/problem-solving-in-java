package examples.interviewquestions.strings.easy;

public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreeConsecutiveOdds solution = new ThreeConsecutiveOdds();


        int[] arr1 = {2, 6, 4, 1};
        System.out.println(solution.threeConsecutiveOdds(arr1));

        int[] arr2 = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(solution.threeConsecutiveOdds(arr2));
    }
}
