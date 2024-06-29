package examples.interviewquestions.twopointers;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueIndex++] = nums[i];
            }
        }
        return uniqueIndex;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2};
        int newLength = solution.removeDuplicates(nums);
        System.out.println("New Length: " + newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
