package examples.interviewquestions.arrays.medium;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengerChanges = new int[1001];

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            passengerChanges[from] += numPassengers;

            passengerChanges[to] -= numPassengers;
        }

        int currentPassengers = 0;

        for (int i = 0; i < 1001; i++) {
            currentPassengers += passengerChanges[i];

            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CarPooling solution = new CarPooling();

        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
        int capacity1 = 4;
        System.out.println(solution.carPooling(trips1, capacity1));

        int[][] trips2 = {{2, 1, 5}, {3, 3, 7}};
        int capacity2 = 5;
        System.out.println(solution.carPooling(trips2, capacity2));
    }
}
