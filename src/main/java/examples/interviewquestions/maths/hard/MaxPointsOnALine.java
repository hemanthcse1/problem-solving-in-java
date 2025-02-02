package examples.interviewquestions.maths.hard;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points.length < 2) return points.length;
        int maxOverall = 1;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 0, maxSlopeCount = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(dy, dx);
                dx /= gcd;
                dy /= gcd;

                String slopeKey = dy + "/" + dx;
                slopeMap.put(slopeKey, slopeMap.getOrDefault(slopeKey, 0) + 1);
                maxSlopeCount = Math.max(maxSlopeCount, slopeMap.get(slopeKey));
            }

            maxOverall = Math.max(maxOverall, maxSlopeCount + duplicate + 1);
        }

        return maxOverall;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        MaxPointsOnALine solution = new MaxPointsOnALine();
        System.out.println(solution.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}})); //  3
        System.out.println(solution.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}})); //  4
    }
}
