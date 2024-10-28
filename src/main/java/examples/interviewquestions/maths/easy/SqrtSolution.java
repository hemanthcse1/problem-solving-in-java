package examples.interviewquestions.maths.easy;

public class SqrtSolution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        SqrtSolution solution = new SqrtSolution();

        int result1 = solution.mySqrt(4);
        System.out.println("The square root of 4 is: " + result1);

        int result2 = solution.mySqrt(8);
        System.out.println("The square root of 8 is: " + result2);
    }
}
