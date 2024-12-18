package examples.interviewquestions.arrays.medium;

public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num : nums){
            if(num <= first){
                first = num;
            }
            else if(num <= second){
                second = num;
            }
            else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4, 5};
        boolean result1 = increasingTriplet(nums1);
        printResult(result1);

        int[] nums2 = {5, 4, 3, 2, 1};
        boolean result2 = increasingTriplet(nums2);
        printResult(result2);

    }

    public static void printResult(boolean result) {
        System.out.println(result);
    }
}
