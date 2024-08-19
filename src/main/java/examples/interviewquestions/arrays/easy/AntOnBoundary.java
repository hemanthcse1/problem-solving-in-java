package examples.interviewquestions.arrays.easy;

public class AntOnBoundary {
    public static int countBoundaryReturns(int[] nums) {
        int position = 0;
        int boundaryReturns = 0;

        for (int num : nums) {
            position += num;
            if (position == 0) {
                boundaryReturns++;
            }
        }

        return boundaryReturns;
    }

    public static void main(String[] args) {
        int[] nums = {2, -2, 3, -3, 4, -4};
        int result = countBoundaryReturns(nums);
        System.out.println("Number of times the ant returns to the boundary: " + result);
    }
}
