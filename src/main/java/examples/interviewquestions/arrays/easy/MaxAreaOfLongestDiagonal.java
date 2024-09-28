package examples.interviewquestions.arrays.easy;

public class MaxAreaOfLongestDiagonal {
    public int maxAreaOfLongestDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxArea = 0;

        for (int[] dim : dimensions) {
            int length = dim[0];
            int width = dim[1];
            double diagonal = Math.sqrt(length * length + width * width);
            int area = length * width;

            if (diagonal > maxDiagonal || (diagonal == maxDiagonal && area > maxArea)) {
                maxDiagonal = diagonal;
                maxArea = area;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaOfLongestDiagonal solution = new MaxAreaOfLongestDiagonal();
        System.out.println(solution.maxAreaOfLongestDiagonal(new int[][]{{9,3}, {8,6}}));
        System.out.println(solution.maxAreaOfLongestDiagonal(new int[][]{{3,4}, {4,3}}));
    }
}
