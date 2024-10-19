package examples.interviewquestions.arrays.medium;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int start = i;
                int length = 0;

                while (!visited[start]) {
                    visited[start] = true;
                    start = nums[start];
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        ArrayNesting solution = new ArrayNesting();

        int[] nums1 = {5, 4, 0, 3, 1, 6, 2};
        System.out.println("Longest Set Length: " + solution.arrayNesting(nums1));

        int[] nums2 = {0, 1, 2};
        System.out.println("Longest Set Length: " + solution.arrayNesting(nums2));
    }
}
