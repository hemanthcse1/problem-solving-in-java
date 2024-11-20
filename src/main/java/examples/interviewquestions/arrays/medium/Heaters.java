package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int maxRadius = 0;

        for (int house : houses) {
            int nearestHeaterDistance = findNearestHeaterDistance(house, heaters);
            maxRadius = Math.max(maxRadius, nearestHeaterDistance);
        }

        return maxRadius;
    }

    private int findNearestHeaterDistance(int house, int[] heaters) {
        int left = 0, right = heaters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] < house) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int distLeft = right >= 0 ? house - heaters[right] : Integer.MAX_VALUE;
        int distRight = left < heaters.length ? heaters[left] - house : Integer.MAX_VALUE;

        return Math.min(distLeft, distRight);
    }

    public static void main(String[] args) {
        Heaters solution = new Heaters();
        System.out.println(solution.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(solution.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(solution.findRadius(new int[]{1, 5}, new int[]{2}));
    }
}
