package examples.interviewquestions.strings.easy;

import java.util.ArrayList;
import java.util.List;

public class ExcelCellsInRange {

    public static List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        char col1 = s.charAt(0);
        int row1 = s.charAt(1) - '0';
        char col2 = s.charAt(3);
        int row2 = s.charAt(4) - '0';

        int maxColumns = col2 - col1 + 1;
        int maxRows = row2 - row1 + 1;
        if (maxColumns * maxRows > 10000) {
            throw new IllegalArgumentException("Range too large. " +
                    "Maximum of 10,000 cells allowed.");
        }
        for (char col = col1; col <= col2; col++) {
            for (int row = row1; row <= row2; row++) {
                result.add("" + col + row);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        try {
            String input = "K1:L2";
            List<String> cells = cellsInRange(input);
            System.out.println(cells);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
