package examples.interviewquestions.graphs.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms1 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList()
        );
        System.out.println(canVisitAllRooms(rooms1));

        List<List<Integer>> rooms2 = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 0, 1),
                Arrays.asList(2),
                Arrays.asList(0)
        );
        System.out.println(canVisitAllRooms(rooms2));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}
