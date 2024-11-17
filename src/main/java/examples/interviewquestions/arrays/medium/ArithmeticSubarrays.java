package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];

            int[] subarray = Arrays.copyOfRange(nums, left, right + 1);

            Arrays.sort(subarray);

            boolean isArithmetic = true;
            int diff = subarray[1] - subarray[0];
            for (int j = 2; j < subarray.length; j++) {
                if (subarray[j] - subarray[j - 1] != diff) {
                    isArithmetic = false;
                    break;
                }
            }

            answer.add(isArithmetic);
        }

        return answer;
    }

    public static void main(String[] args) {
        ArithmeticSubarrays sol = new ArithmeticSubarrays();

        int[] nums1 = {4, 6, 5, 9, 3, 7};
        int[] l1 = {0, 0, 2};
        int[] r1 = {2, 3, 5};
        System.out.println(sol.checkArithmeticSubarrays(nums1, l1, r1));

        int[] nums2 = {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
        int[] l2 = {0, 1, 6, 4, 8, 7};
        int[] r2 = {4, 4, 9, 7, 9, 10};
        System.out.println(sol.checkArithmeticSubarrays(nums2, l2, r2));
    }
}
