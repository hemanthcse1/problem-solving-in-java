package examples.interviewquestions.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class NeighborSum {

    private int[][] grid;
    private int n;
    private Map<Integer, int[]> valueToPosition;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.valueToPosition = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                valueToPosition.put(grid[i][j], new int[] {i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        int[] position = valueToPosition.get(value);
        int row = position[0];
        int col = position[1];
        int sum = 0;

        if (row > 0) sum += grid[row - 1][col];
        if (row < n - 1) sum += grid[row + 1][col];
        if (col > 0) sum += grid[row][col - 1];
        if (col < n - 1) sum += grid[row][col + 1];

        return sum;
    }

    public int diagonalSum(int value) {
        int[] position = valueToPosition.get(value);
        int row = position[0];
        int col = position[1];
        int sum = 0;

        if (row > 0 && col > 0) sum += grid[row - 1][col - 1];
        if (row > 0 && col < n - 1) sum += grid[row - 1][col + 1];
        if (row < n - 1 && col > 0) sum += grid[row + 1][col - 1];
        if (row < n - 1 && col < n - 1) sum += grid[row + 1][col + 1];

        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };

        NeighborSum neighborSum = new NeighborSum(grid);
        System.out.println("Adjacent sum of 4: " + neighborSum.adjacentSum(4));
        System.out.println("Diagonal sum of 4: " + neighborSum.diagonalSum(4));
    }
}
