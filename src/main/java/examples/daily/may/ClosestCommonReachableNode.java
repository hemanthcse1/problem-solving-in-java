package examples.daily.may;

import java.util.Arrays;

public class ClosestCommonReachableNode {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = getDistances(edges, node1, n);
        int[] dist2 = getDistances(edges, node2, n);

        int minDistance = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDistance) {
                    minDistance = maxDist;
                    result = i;
                }
            }
        }

        return result;
    }

    private int[] getDistances(int[] edges, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        int current = start;
        int d = 0;

        while (current != -1 && dist[current] == -1) {
            dist[current] = d++;
            current = edges[current];
        }

        return dist;
    }

    public static void main(String[] args) {
        ClosestCommonReachableNode solution = new ClosestCommonReachableNode();

        int[] edges1 = {2, 2, 3, -1};
        System.out.println("Output: " + solution.closestMeetingNode(edges1, 0, 1)); // Expected: 2

        int[] edges2 = {1, 2, -1};
        System.out.println("Output: " + solution.closestMeetingNode(edges2, 0, 2)); // Expected: 2
    }
}
