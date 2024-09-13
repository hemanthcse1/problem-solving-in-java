package examples.interviewquestions.strings.easy;

public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int clockwiseDistance = 0;
        int totalDistance = 0;

        for (int i = 0; i < distance.length; i++) {
            totalDistance += distance[i];
            if (i >= start && i < destination) {
                clockwiseDistance += distance[i];
            }
        }

        int counterClockwiseDistance = totalDistance - clockwiseDistance;

        return Math.min(clockwiseDistance, counterClockwiseDistance);
    }

    public static void main(String[] args) {
        DistanceBetweenBusStops solution = new DistanceBetweenBusStops();

        int[] distance1 = {1, 2, 3, 4};
        System.out.println(solution.distanceBetweenBusStops(distance1, 0, 1));

        int[] distance2 = {1, 2, 3, 4};
        System.out.println(solution.distanceBetweenBusStops(distance2, 0, 2));

        int[] distance3 = {1, 2, 3, 4};
        System.out.println(solution.distanceBetweenBusStops(distance3, 0, 3));
    }
}
