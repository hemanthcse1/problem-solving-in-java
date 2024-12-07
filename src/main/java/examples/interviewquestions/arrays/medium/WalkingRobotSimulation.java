package examples.interviewquestions.arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Set<String> obstacleSet = new HashSet<>();

        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int x = 0, y = 0, direction = 0, maxDistance = 0;

        for (int command : commands) {
            if (command == -2) {
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int step = 0; step < command; step++) {
                    int nextX = x + dx[direction];
                    int nextY = y + dy[direction];

                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;
                    }

                    x = nextX;
                    y = nextY;
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        WalkingRobotSimulation solution = new WalkingRobotSimulation();

        int[] commands1 = {4, -1, 3};
        int[][] obstacles1 = {};
        System.out.println(solution.robotSim(commands1, obstacles1));

        int[] commands2 = {4, -1, 4, -2, 4};
        int[][] obstacles2 = {{2, 4}};
        System.out.println(solution.robotSim(commands2, obstacles2));
    }
}
