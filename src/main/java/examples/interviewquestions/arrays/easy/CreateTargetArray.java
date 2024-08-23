package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> targetList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            targetList.add(index[i], nums[i]);
        }
        int[] targetArray = new int[targetList.size()];
        for (int i = 0; i < targetList.size(); i++) {
            targetArray[i] = targetList.get(i);
        }

        return targetArray;
    }

    public static void main(String[] args) {
        CreateTargetArray solution = new CreateTargetArray();

        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        int[] result = solution.createTargetArray(nums, index);

        System.out.println("Target array: " + java.util.Arrays.toString(result));
    }
}
