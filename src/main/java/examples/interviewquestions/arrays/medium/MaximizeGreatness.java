package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class MaximizeGreatness {

    public static int maximizeGreatness(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] perm = nums.clone();
        Arrays.sort(perm);
        int i = 0, j = 0, count = 0;
        while (i < n && j < n) {
            if (perm[j] > sorted[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,2,1,3,1};
        System.out.println(maximizeGreatness(nums));
    }
}
