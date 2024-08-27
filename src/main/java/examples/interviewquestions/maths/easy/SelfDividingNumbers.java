package examples.interviewquestions.maths.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int num = left; num <= right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }

        return result;
    }

    private boolean isSelfDividing(int num) {
        int originalNum = num;

        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || originalNum % digit != 0) {
                return false;
            }
            num /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        SelfDividingNumbers solver = new SelfDividingNumbers();
        System.out.println(solver.selfDividingNumbers(1, 22));
    }
}
