package examples.interviewquestions.arrays;

public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        for (int i = 1; i < points.length; i++) {
            int[] current = points[i];
            int[] previous = points[i - 1];
            int dx = Math.abs(current[0] - previous[0]);
            int dy = Math.abs(current[1] - previous[1]);
            totalTime += Math.max(dx, dy);
        }

        return totalTime;
    }

    public static void main(String[] args) {
        MinimumTimeVisitingAllPoints solution = new MinimumTimeVisitingAllPoints();

        int[][] points1 = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(solution.minTimeToVisitAllPoints(points1));

        int[][] points2 = {{3, 2}, {-2, 2}};
        System.out.println(solution.minTimeToVisitAllPoints(points2));
    }
}
