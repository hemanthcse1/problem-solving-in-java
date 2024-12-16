package examples.interviewquestions.matrixes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> result = new ArrayList<>();
        int total = rows * cols;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int stepLength = 1;
        int r = rStart, c = cStart;
        result.add(new int[]{r, c});
        while (result.size() < total) {
            for(int i = 0; i < 4; i++) {
                for(int s = 0; s < stepLength; s++) {
                    r += directions[i][0];
                    c += directions[i][1];
                    if(r >=0 && r < rows && c >=0 && c < cols){
                        result.add(new int[]{r, c});
                        if(result.size() == total) break;
                    }
                }
                if(i ==1 || i ==3){
                    stepLength++;
                }
                if(result.size() == total){
                    break;
                }
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        SpiralMatrixIII solver = new SpiralMatrixIII();

        int rows1 = 1;
        int cols1 = 4;
        int rStart1 = 0;
        int cStart1 = 0;
        int[][] result1 = solver.spiralMatrixIII(rows1, cols1, rStart1, cStart1);
        System.out.println("Output for Example 1:");
        printMatrix(result1);

        int rows2 = 5;
        int cols2 = 6;
        int rStart2 = 1;
        int cStart2 = 4;
        int[][] result2 = solver.spiralMatrixIII(rows2, cols2, rStart2, cStart2);
        System.out.println("Output for Example 2:");
        printMatrix(result2);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.print("[");
        for(int i = 0; i < matrix.length; i++) {
            System.out.print(Arrays.toString(matrix[i]));
            if(i < matrix.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
