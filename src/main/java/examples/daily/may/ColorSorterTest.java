package examples.daily.may;

public class ColorSorterTest {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Original Array:");
        printArray(nums);

        ColorSorterTest solution = new ColorSorterTest();
        solution.sortColors(nums);

        System.out.println("Sorted Array:");
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public void sortColors(int[] nums) {
        for (int lastUnSortedIndex = 0; lastUnSortedIndex < nums.length - 1; lastUnSortedIndex++) {

            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
