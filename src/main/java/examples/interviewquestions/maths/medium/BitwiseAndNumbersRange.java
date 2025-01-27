package examples.interviewquestions.maths.medium;

public class BitwiseAndNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;
    }

    public static void main(String[] args) {
        BitwiseAndNumbersRange solution = new BitwiseAndNumbersRange();


        int left1 = 5, right1 = 7;
        System.out.println(solution.rangeBitwiseAnd(left1, right1));


        int left2 = 0, right2 = 0;
        System.out.println(solution.rangeBitwiseAnd(left2, right2));
    }
}
