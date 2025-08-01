package examples.daily.august;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++){
            List<Integer> rowItems = new ArrayList<>();
            rowItems.add(1);

            for (int col = 1; col < row; col++){
                int sum = triangle.get(row - 1).get(col - 1) + triangle.get(row -1).get(col);
                rowItems.add(sum);
            }

            if (row > 0){
                rowItems.add(1);
            }

            triangle.add(rowItems);
        }

        return triangle;
    }
}
