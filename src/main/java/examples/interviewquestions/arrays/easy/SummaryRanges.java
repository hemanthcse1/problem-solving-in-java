package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }

        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }

        return result;
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> ranges = sr.summaryRanges(nums);
        System.out.println(ranges);  // Output: [0->2, 4->5, 7]

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        List<String> ranges2 = sr.summaryRanges(nums2);
        System.out.println(ranges2);  // Output: [0, 2->4, 6, 8->9]
    }
}
