package examples.interviewquestions.twopointers;

import java.util.Arrays;

public class SortArrayByParity {

    public static void main(String[] args) {

        int[] nums = {3,1,2,4};
        System.out.println("Before Parity "+ Arrays.toString(nums));
        System.out.println("after Parity \n "+ Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums){
        int[] result = new int[nums.length];
        int index = 0;

        for (int num: nums){
            if (num % 2 == 0){
                result[index++] = num;
            }
        }
        for (int num: nums){
            if (num%2 != 0){
                result[index++] = num;
            }
        }
        return result;
    }
}
