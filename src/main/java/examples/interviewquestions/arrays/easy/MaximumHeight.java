package examples.interviewquestions.arrays.easy;

public class MaximumHeight {
    public int maximumHeight(int red, int blue) {
        int height = 0;
        int currentRow = 1;
        boolean useRed = true;

        while (true) {
            if (useRed) {
                if (red >= currentRow) {
                    red -= currentRow;
                } else {
                    break;
                }
            } else {
                if (blue >= currentRow) {
                    blue -= currentRow;
                } else {
                    break;
                }
            }

            height++;
            currentRow++;
            useRed = !useRed;
        }

        return height;
    }

    public static void main(String[] args) {
        MaximumHeight solution = new MaximumHeight();
        System.out.println(solution.maximumHeight(2, 4));
        System.out.println(solution.maximumHeight(2, 1));
        System.out.println(solution.maximumHeight(1, 1));
        System.out.println(solution.maximumHeight(10, 1));
    }
}
