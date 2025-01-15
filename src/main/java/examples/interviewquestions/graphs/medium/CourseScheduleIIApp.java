package examples.interviewquestions.graphs.medium;

import java.util.*;

public class CourseScheduleIIApp {

    public static void main(String[] args) {
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(Arrays.toString(findOrder(2, prerequisites1)));

        int[][] prerequisites2 = {{1,0}, {2,0}, {3,1}, {3,2}};
        System.out.println(Arrays.toString(findOrder(4, prerequisites2)));

        int[][] prerequisites3 = {};
        System.out.println(Arrays.toString(findOrder(1, prerequisites3)));

        int[][] prerequisites4 = {{0,1}, {1,0}};
        System.out.println(Arrays.toString(findOrder(2, prerequisites4)));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        int[] inDegree = new int[numCourses];
        for(int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        int[] result = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            for(int neighbor : adj.get(course)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return index == numCourses ? result : new int[]{};
    }
}
