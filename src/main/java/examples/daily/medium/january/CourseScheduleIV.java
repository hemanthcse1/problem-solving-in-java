package examples.daily.medium.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleIV {
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        boolean[][] reachable = new boolean[numCourses][numCourses];


        for (int[] prerequisite : prerequisites) {
            reachable[prerequisite[0]][prerequisite[1]] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }


        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }

    public static void main(String[] args) {

        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries = {{1, 0}, {1, 2}, {2, 0}, {0, 2}};
        List<Boolean> result = checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(result); // Output: [true, true, true, false]
    }
}
