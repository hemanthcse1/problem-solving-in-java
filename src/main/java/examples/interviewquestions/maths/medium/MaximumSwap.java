package examples.interviewquestions.maths.medium;

public class MaximumSwap {

    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] lastIndex = new int[10];

        for (int i = 0; i < digits.length; i++) {
            lastIndex[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastIndex[d] > i) {
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        MaximumSwap solution = new MaximumSwap();
        System.out.println(solution.maximumSwap(2736));
        System.out.println(solution.maximumSwap(9973));
    }
}
