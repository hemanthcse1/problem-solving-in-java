package examples.interviewquestions.arrays.medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                startingStation = i + 1;
                currentGas = 0;
            }
        }

        if (totalGas < totalCost) {
            return -1;
        }

        return startingStation;
    }

    public static void main(String[] args) {
        GasStation solution = new GasStation();

        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Output: " + solution.canCompleteCircuit(gas1, cost1));

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Output: " + solution.canCompleteCircuit(gas2, cost2));
    }
}
