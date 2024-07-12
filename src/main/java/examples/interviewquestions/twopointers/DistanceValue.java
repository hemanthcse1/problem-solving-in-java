package examples.interviewquestions.twopointers;

public class DistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        for (int num1 : arr1) {
            boolean isValid = true;
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        DistanceValue solution = new DistanceValue();
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;
        int result = solution.findTheDistanceValue(arr1, arr2, d);
        System.out.println("Distance Value: " + result);
    }
}
