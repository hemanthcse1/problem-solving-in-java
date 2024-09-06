package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class AppleRedistribution {
    public static int minBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int apples : apple) {
            totalApples += apples;
        }

        Arrays.sort(capacity);

        int currentCapacity = 0;
        int boxesUsed = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            currentCapacity += capacity[i];
            boxesUsed++;
            if (currentCapacity >= totalApples) {
                return boxesUsed;
            }
        }

        return boxesUsed;
    }

    public static void main(String[] args) {
        int[] apple = {5, 10, 15};
        int[] capacity = {20, 5, 10, 30};

        int result = minBoxes(apple, capacity);
        System.out.println("Minimum number of boxes needed: " + result);
    }
}
