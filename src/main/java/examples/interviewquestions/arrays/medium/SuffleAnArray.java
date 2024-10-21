package examples.interviewquestions.arrays.medium;

import java.util.Random;

public class SuffleAnArray {
    private int[] original;
    private int[] array;
    private Random random;

    public SuffleAnArray(int[] nums) {
        this.original = nums.clone();
        this.array = nums.clone();
        this.random = new Random();
    }

    public int[] reset() {
        this.array = original.clone();
        return this.array;
    }

    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(i, j);
        }
        return array;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        SuffleAnArray solution = new SuffleAnArray(nums);

        System.out.println("Shuffled: " + java.util.Arrays.toString(solution.shuffle()));

        System.out.println("Reset: " + java.util.Arrays.toString(solution.reset()));

        System.out.println("Shuffled again: " + java.util.Arrays.toString(solution.shuffle()));
    }
}
