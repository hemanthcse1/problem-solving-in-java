package examples.interviewquestions.arrays.easy;

public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        int dx = x2 - x1;
        int dy = y2 - y1;

        for (int i = 2; i < coordinates.length; i++) {
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];

            if ((y3 - y2) * dx != (x3 - x2) * dy) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckStraightLine solution = new CheckStraightLine();

        int[][] coordinates1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(solution.checkStraightLine(coordinates1));

        int[][] coordinates2 = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        System.out.println(solution.checkStraightLine(coordinates2));
    }
}
