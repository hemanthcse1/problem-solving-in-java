package examples.interviewquestions.strings.easy;

public class ChessboardColorChecker {
    public static boolean haveSameColor(String coordinate1, String coordinate2) {
        int col1 = columnIndex(coordinate1.charAt(0));
        int row1 = Character.getNumericValue(coordinate1.charAt(1));

        int col2 = columnIndex(coordinate2.charAt(0));
        int row2 = Character.getNumericValue(coordinate2.charAt(1));

        return (col1 + row1) % 2 == (col2 + row2) % 2;
    }
    static int columnIndex(char column) {
        return column - 'a' + 1;
    }

    public static void main(String[] args) {
        String coordinate1 = "a1";
        String coordinate2 = "c3";

        System.out.println("Do the squares have the same color? " + haveSameColor(coordinate1, coordinate2));
        // Expected output: true (both are black)
    }
}
