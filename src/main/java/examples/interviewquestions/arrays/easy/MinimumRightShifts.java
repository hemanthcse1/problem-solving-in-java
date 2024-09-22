package examples.interviewquestions.arrays.easy;

import java.util.List;

public class MinimumRightShifts {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        int breakPoint = -1;

        for (int i = 0; i < n; i++) {
            if (nums.get(i) > nums.get((i + 1) % n)) {
                if (breakPoint == -1) {
                    breakPoint = i;
                } else {
                    return -1;
                }
            }
        }

        if (breakPoint == -1) {
            return 0;
        }

        return n - breakPoint - 1;
    }

    public static void main(String[] args) {
        MinimumRightShifts sol = new MinimumRightShifts();

        List<Integer> nums1 = List.of(3, 4, 5, 1, 2);
        System.out.println(sol.minimumRightShifts(nums1));

        List<Integer> nums2 = List.of(1, 3, 5);
        System.out.println(sol.minimumRightShifts(nums2));

        List<Integer> nums3 = List.of(2, 1, 4);
        System.out.println(sol.minimumRightShifts(nums3));
    }
}
