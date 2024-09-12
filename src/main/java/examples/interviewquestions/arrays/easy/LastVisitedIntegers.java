package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class LastVisitedIntegers {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k = 0;

        for (int num : nums) {
            if (num == -1) {
                k++;
                if (k <= seen.size()) {
                    ans.add(seen.get(k - 1));
                } else {
                    ans.add(-1);
                }
            } else {
                k = 0;
                seen.add(0, num);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LastVisitedIntegers solution = new LastVisitedIntegers();

        int[] nums1 = {5, -1, 6, -1, -1};
        System.out.println(solution.lastVisitedIntegers(nums1));


        int[] nums2 = {1, 2, 3, -1, -1, -1};
        System.out.println(solution.lastVisitedIntegers(nums2));

        int[] nums3 = {-1, 4, -1, -1, -1};
        System.out.println(solution.lastVisitedIntegers(nums3));
    }
}
