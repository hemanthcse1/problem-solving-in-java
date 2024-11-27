package examples.interviewquestions.arrays.medium;

public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        long currentTime = 0;
        long totalWaitingTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int preparationTime = customer[1];
            currentTime = Math.max(currentTime, arrivalTime);
            currentTime += preparationTime;
            totalWaitingTime += (currentTime - arrivalTime);
        }

        return (double) totalWaitingTime / customers.length;
    }

    public static void main(String[] args) {
        AverageWaitingTime solver = new AverageWaitingTime();

        int[][] customers1 = {{1, 2}, {2, 5}, {4, 3}};
        System.out.printf("%.5f%n", solver.averageWaitingTime(customers1));

        int[][] customers2 = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        System.out.printf("%.5f%n", solver.averageWaitingTime(customers2));
    }
}
