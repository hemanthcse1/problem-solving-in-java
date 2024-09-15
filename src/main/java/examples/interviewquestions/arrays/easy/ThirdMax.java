package examples.interviewquestions.arrays.easy;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for (Integer num : nums) {
            if (num.equals(firstMax) || num.equals(secondMax) || num.equals(thirdMax)) {
                continue;
            }

            if (firstMax == null || num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (secondMax == null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }

        return (thirdMax == null) ? firstMax : thirdMax;
    }

    public static void main(String[] args) {
        ThirdMax solution = new ThirdMax();

        int[] nums1 = {3, 2, 1};
        System.out.println(solution.thirdMax(nums1));


        int[] nums2 = {1, 2};
        System.out.println(solution.thirdMax(nums2));


        int[] nums3 = {2, 2, 3, 1};
        System.out.println(solution.thirdMax(nums3));
    }
}
