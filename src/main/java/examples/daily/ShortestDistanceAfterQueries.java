package examples.daily;

import java.util.*;

public class ShortestDistanceAfterQueries {

    public int[] shortestPathLength(int n, int[][] queries) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            if (i < n - 1) {
                graph[i].add(new int[]{i + 1, 1});
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph[u].add(new int[]{v, 1});

            result[i] = bfsShortestPath(graph, n, 0, n - 1);
        }

        return result;
    }

    private int bfsShortestPath(List<int[]>[] graph, int n, int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        boolean[] visited = new boolean[n];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            if (node == end) {
                return distance;
            }

            if (visited[node]) continue;
            visited[node] = true;

            for (int[] neighbor : graph[node]) {
                if (!visited[neighbor[0]]) {
                    queue.offer(new int[]{neighbor[0], distance + neighbor[1]});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestDistanceAfterQueries solver = new ShortestDistanceAfterQueries();

        int n1 = 5;
        int[][] queries1 = {{2, 4}, {0, 2}, {0, 4}};
        System.out.println(Arrays.toString(solver.shortestPathLength(n1, queries1)));

        int n2 = 4;
        int[][] queries2 = {{0, 3}, {0, 2}};
        System.out.println(Arrays.toString(solver.shortestPathLength(n2, queries2)));
    }
}
