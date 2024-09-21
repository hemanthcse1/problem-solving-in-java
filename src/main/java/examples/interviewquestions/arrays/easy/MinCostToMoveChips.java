package examples.interviewquestions.arrays.easy;

public class MinCostToMoveChips {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;
        int oddCount = 0;

        for (int pos : position) {
            if (pos % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return Math.min(evenCount, oddCount);
    }

    public static void main(String[] args) {
        MinCostToMoveChips solution = new MinCostToMoveChips();

        int[] position1 = {1, 2, 3};
        System.out.println(solution.minCostToMoveChips(position1));

        int[] position2 = {2, 2, 2, 3, 3};
        System.out.println(solution.minCostToMoveChips(position2));

        int[] position3 = {1, 1000000000};
        System.out.println(solution.minCostToMoveChips(position3));
    }
}
