package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int totalElements = m * n;

        k = k % totalElements;

        int[][] newGrid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentIndex = i * n + j;

                int newIndex = (currentIndex + k) % totalElements;

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                newGrid[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(newGrid[i][j]);
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k1 = 1;
        System.out.println(shiftGrid(grid1, k1));

        int[][] grid2 = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        int k2 = 4;
        System.out.println(shiftGrid(grid2, k2));

        int[][] grid3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k3 = 9;
        System.out.println(shiftGrid(grid3, k3));
    }
}
