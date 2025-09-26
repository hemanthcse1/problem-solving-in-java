package examples.daily.september;

import java.util.Arrays;
import java.util.Scanner;

public class ValidTriangleNumber {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            if (nums[k] == 0) continue;
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = triangleNumber(nums);
        System.out.println("Number of valid triangles: " + result);

        System.out.println("Test [2,2,3,4] -> " + triangleNumber(new int[]{2,2,3,4})); // 3
        System.out.println("Test [4,2,3,4] -> " + triangleNumber(new int[]{4,2,3,4})); // 4
    }
}
