package examples.interviewquestions.arrays.easy;

public class FinalPosition {
    public int finalPosition(int n, String[] commands) {
        int row = 0;
        int col = 0;

        for (String command : commands) {
            switch (command) {
                case "UP":
                    row--;
                    break;
                case "DOWN":
                    row++;
                    break;
                case "LEFT":
                    col--;
                    break;
                case "RIGHT":
                    col++;
                    break;
            }
        }

        return (row * n) + col;
    }

    public static void main(String[] args) {
        FinalPosition sol = new FinalPosition();

        String[] commands1 = {"RIGHT", "DOWN"};
        System.out.println(sol.finalPosition(2, commands1));

        String[] commands2 = {"DOWN", "RIGHT", "UP"};
        System.out.println(sol.finalPosition(3, commands2));
    }
}
