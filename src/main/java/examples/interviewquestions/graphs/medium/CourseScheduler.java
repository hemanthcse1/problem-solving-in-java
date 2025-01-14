package examples.interviewquestions.graphs.medium;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduler {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(graph, state, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] state, int course) {
        state[course] = 1;
        for (int next : graph.get(course)) {
            if (state[next] == 1) {
                return true;
            }
            if (state[next] == 0 && hasCycle(graph, state, next)) {
                return true;
            }
        }
        state[course] = 2;
        return false;
    }

    public static void main(String[] args) {
        CourseScheduler scheduler = new CourseScheduler();
        int[][] prereq1 = {{1, 0}};
        System.out.println(scheduler.canFinish(2, prereq1));

        int[][] prereq2 = {{1, 0}, {0, 1}};
        System.out.println(scheduler.canFinish(2, prereq2));
    }
}
