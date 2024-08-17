package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class SortEvenOddIndices {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int[] even = new int[(n + 1) / 2];
        int[] odd = new int[n / 2];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[i / 2] = nums[i];
            } else {
                odd[i / 2] = nums[i];
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        reverse(odd);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = even[i / 2];
            } else {
                nums[i] = odd[i / 2];
            }
        }
        return nums;
    }
    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        SortEvenOddIndices sorter = new SortEvenOddIndices();

        int[] nums1 = {4, 1, 2, 3};
        System.out.println(Arrays.toString(sorter.sortEvenOdd(nums1)));

        int[] nums2 = {2, 1};
        System.out.println(Arrays.toString(sorter.sortEvenOdd(nums2)));

        int[] nums3 = {5, 2, 9, 1, 4, 6};
        System.out.println(Arrays.toString(sorter.sortEvenOdd(nums3)));
    }
}
