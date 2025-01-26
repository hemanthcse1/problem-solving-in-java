package examples.daily.medium.january;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumEmployeesMeeting {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        boolean[] visited = new boolean[n];
        int[] cycleSize = new int[n];
        int maxCycle = 0;
        int[] indegree = new int[n];
        int[] chainLength = new int[n];

        for (int i = 0; i < n; i++) {
            indegree[favorite[i]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;
            chainLength[favorite[current]] = Math.max(chainLength[favorite[current]], chainLength[current] + 1);
            if (--indegree[favorite[current]] == 0) {
                queue.offer(favorite[current]);
            }
        }

        boolean[] inTwoCycle = new boolean[n];
        int twoCycleChains = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> cycle = new ArrayList<>();
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    cycle.add(current);
                    current = favorite[current];
                }

                if (cycle.size() == 2) {
                    inTwoCycle[cycle.get(0)] = true;
                    inTwoCycle[cycle.get(1)] = true;
                    twoCycleChains += chainLength[cycle.get(0)] + chainLength[cycle.get(1)] + 2;
                } else {
                    maxCycle = Math.max(maxCycle, cycle.size());
                }
            }
        }

        return Math.max(maxCycle, twoCycleChains);
    }

    public static void main(String[] args) {
        MaximumEmployeesMeeting solver = new MaximumEmployeesMeeting();
        System.out.println(solver.maximumInvitations(new int[]{2, 2, 1, 2})); // 3
        System.out.println(solver.maximumInvitations(new int[]{1, 2, 0}));   // 3
        System.out.println(solver.maximumInvitations(new int[]{3, 0, 1, 4, 1})); //  4
    }
}
