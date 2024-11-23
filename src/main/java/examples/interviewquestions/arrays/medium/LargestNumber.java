package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        if (numStrs[0].equals("0")) {
            return "0";
        }

        StringBuilder largestNum = new StringBuilder();
        for (String num : numStrs) {
            largestNum.append(num);
        }

        return largestNum.toString();
    }

    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();

        int[] nums1 = {10, 2};
        System.out.println("Largest number for nums1: " + solution.largestNumber(nums1));

        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("Largest number for nums2: " + solution.largestNumber(nums2));
    }
}
