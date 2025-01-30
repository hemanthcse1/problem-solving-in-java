package examples.daily.medium.january;

import java.util.*;

public class MaxGroupsGraph {

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        int maxGroups = 0;

        for (int node = 1; node <= n; node++) {
            if (color[node] == -1) {
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(graph, node, color, component)) return -1;

                int bestDepth = 0;
                for (int startNode : component) {
                    bestDepth = Math.max(bestDepth, getMaxDepth(graph, startNode));
                }
                maxGroups += bestDepth;
            }
        }

        return maxGroups;
    }

    private boolean isBipartite(List<List<Integer>> graph, int start, int[] color, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;
        component.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.offer(neighbor);
                    component.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    private int getMaxDepth(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();
        queue.offer(start);
        depth.put(start, 1);
        int maxDepth = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!depth.containsKey(neighbor)) {
                    depth.put(neighbor, depth.get(node) + 1);
                    queue.offer(neighbor);
                    maxDepth = Math.max(maxDepth, depth.get(neighbor));
                }
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        MaxGroupsGraph solution = new MaxGroupsGraph();
        System.out.println(solution.magnificentSets(6, new int[][]{{1,2},{1,4},{1,5},{2,6},{2,3},{4,6}})); //  4
        System.out.println(solution.magnificentSets(3, new int[][]{{1,2},{2,3},{3,1}})); //  -1
    }
}
