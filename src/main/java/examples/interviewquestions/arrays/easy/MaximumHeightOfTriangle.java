package examples.interviewquestions.arrays.easy;

public class MaximumHeightOfTriangle {

    public int maxHeightOfTriangle(int red, int blue) {
        int height = 0;
        int row = 1;

        while (true) {
            if (row % 2 == 1) {
                if (red >= row) {
                    red -= row;
                    height++;
                } else {
                    break;
                }
            } else {
                if (blue >= row) {
                    blue -= row;
                    height++;
                } else {
                    break;
                }
            }
            row++;
        }

        return height;
    }

    public static void main(String[] args) {
        MaximumHeightOfTriangle solution = new MaximumHeightOfTriangle();
        System.out.println(solution.maxHeightOfTriangle(2, 4));
        System.out.println(solution.maxHeightOfTriangle(7, 8));
    }
}
