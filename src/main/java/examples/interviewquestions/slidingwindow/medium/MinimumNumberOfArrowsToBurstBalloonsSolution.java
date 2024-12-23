package examples.interviewquestions.slidingwindow.medium;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloonsSolution {

    static class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points == null || points.length == 0) return 0;

            Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

            int arrows = 1;
            int lastArrowPos = points[0][1];

            for(int i = 1; i < points.length; i++) {

                if(points[i][0] > lastArrowPos) {
                    arrows++;
                    lastArrowPos = points[i][1];
                }
            }

            return arrows;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();


        int[][] points1 = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println("Minimum Arrows for Example 1: " + solution.findMinArrowShots(points1));


        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println("Minimum Arrows for Example 2: " + solution.findMinArrowShots(points2));


    }
}
