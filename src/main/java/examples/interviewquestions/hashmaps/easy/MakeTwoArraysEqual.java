package examples.interviewquestions.hashmaps.easy;

import java.util.Arrays;

public class MakeTwoArraysEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        return Arrays.equals(target, arr);
    }

    public static void main(String[] args) {
        MakeTwoArraysEqual solver = new MakeTwoArraysEqual();
        int[] target1 = {1, 2, 3, 4};
        int[] arr1 = {2, 4, 1, 3};
        System.out.println(solver.canBeEqual(target1, arr1)); // true

        int[] target2 = {7};
        int[] arr2 = {7};
        System.out.println(solver.canBeEqual(target2, arr2)); // true

        int[] target3 = {3, 7, 9};
        int[] arr3 = {3, 7, 11};
        System.out.println(solver.canBeEqual(target3, arr3)); // false
    }
}
