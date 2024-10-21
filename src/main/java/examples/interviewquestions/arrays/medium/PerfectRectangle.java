package examples.interviewquestions.arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;

        Set<String> corners = new HashSet<>();
        int totalArea = 0;

        for (int[] rect : rectangles) {
            int xStart = rect[0], yStart = rect[1], xEnd = rect[2], yEnd = rect[3];

            x1 = Math.min(x1, xStart);
            y1 = Math.min(y1, yStart);
            x2 = Math.max(x2, xEnd);
            y2 = Math.max(y2, yEnd);

            totalArea += (xEnd - xStart) * (yEnd - yStart);

            String[] currentCorners = {
                    xStart + " " + yStart,
                    xStart + " " + yEnd,
                    xEnd + " " + yStart,
                    xEnd + " " + yEnd
            };

            for (String corner : currentCorners) {
                if (!corners.add(corner)) {
                    corners.remove(corner);
                }
            }
        }

        if (corners.size() != 4 ||
                !corners.contains(x1 + " " + y1) ||
                !corners.contains(x1 + " " + y2) ||
                !corners.contains(x2 + " " + y1) ||
                !corners.contains(x2 + " " + y2)) {
            return false;
        }

        int boundingArea = (x2 - x1) * (y2 - y1);
        return totalArea == boundingArea;
    }

    public static void main(String[] args) {
        PerfectRectangle solution = new PerfectRectangle();

        int[][] rectangles1 = {
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        };
        System.out.println(solution.isRectangleCover(rectangles1));

        int[][] rectangles2 = {
                {1, 1, 2, 3},
                {1, 3, 2, 4},
                {3, 1, 4, 2},
                {3, 2, 4, 4}
        };
        System.out.println(solution.isRectangleCover(rectangles2));

        int[][] rectangles3 = {
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {1, 3, 2, 4},
                {2, 2, 4, 4}
        };
        System.out.println(solution.isRectangleCover(rectangles3));
    }
}
