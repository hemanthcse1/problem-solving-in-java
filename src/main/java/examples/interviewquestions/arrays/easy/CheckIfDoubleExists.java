package examples.interviewquestions.arrays.easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfDoubleExists {
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(2 * num) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 2, 5, 3};
        System.out.println(checkIfExist(arr1));

        int[] arr2 = {3, 1, 7, 11};
        System.out.println(checkIfExist(arr2));
    }
}
