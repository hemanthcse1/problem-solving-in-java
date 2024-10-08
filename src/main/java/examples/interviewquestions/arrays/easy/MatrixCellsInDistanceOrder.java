package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<int[]> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result.add(new int[]{r, c});
            }
        }

        result.sort((a, b) -> {
            int distA = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int distB = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return Integer.compare(distA, distB);
        });

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MatrixCellsInDistanceOrder solver = new MatrixCellsInDistanceOrder();
        System.out.println(Arrays.deepToString(solver.allCellsDistOrder(1, 2, 0, 0)));
        System.out.println(Arrays.deepToString(solver.allCellsDistOrder(2, 2, 0, 1)));
        System.out.println(Arrays.deepToString(solver.allCellsDistOrder(2, 3, 1, 2)));
    }
}
