package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class DistributeElements {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);

        if (nums.length > 1) {
            arr2.add(nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            int lastArr1 = arr1.get(arr1.size() - 1);
            int lastArr2 = arr2.get(arr2.size() - 1);

            if (lastArr1 > lastArr2) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        List<Integer> result = new ArrayList<>(arr1);
        result.addAll(arr2);

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        DistributeElements sol = new DistributeElements();
        int[] nums = {10, 5, 15, 7, 20, 25};
        int[] result = sol.resultArray(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
