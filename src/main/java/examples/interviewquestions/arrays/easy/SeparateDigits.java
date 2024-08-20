package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class SeparateDigits {
    public static int[] separateDigits(int[] nums) {
        List<Integer> answerList = new ArrayList<>();
        for (int num : nums) {
            String numStr = Integer.toString(num);
            for (char digitChar : numStr.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);
                answerList.add(digit);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {10921, 345, 67};
        int[] result = separateDigits(nums);

        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}
