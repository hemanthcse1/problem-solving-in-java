package examples.daily.may;

import java.util.ArrayList;
import java.util.List;

public class TargetNodeMaximizer {

    public static void main(String[] args) {
        int[][] edges1 = {
                {0, 1},
                {0, 2},
                {2, 3},
                {2, 4}
        };

        int[][] edges2 = {
                {0, 1},
                {0, 2},
                {0, 3},
                {2, 7},
                {1, 4},
                {4, 5},
                {4, 6}
        };

        int k = 2;

        TargetNodeMaximizer targetNodeMaximizer = new TargetNodeMaximizer();
        int[] result = targetNodeMaximizer.maxTargetNodes(edges1, edges2, k);

        System.out.print("Maximum target nodes for each node in Tree 1: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int[] result = new int[n];

        List<Integer>[] tree1 = buildGraph(edges1, n);
        List<Integer>[] tree2 = buildGraph(edges2, m);

        int maxReachableInTree2 = 0;
        if (k > 0) {
            for (int i = 0; i < m; i++) {
                maxReachableInTree2 = Math.max(maxReachableInTree2, dfs(tree2, i, -1, k - 1));
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = maxReachableInTree2 + dfs(tree1, i, -1, k);
        }

        return result;
    }

    private int dfs(List<Integer>[] graph, int node, int parent, int steps) {
        if (steps == 0) return 1;

        int count = 1;
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                count += dfs(graph, neighbor, node, steps - 1);
            }
        }
        return count;
    }

    private List<Integer>[] buildGraph(int[][] edges, int size) {
        List<Integer>[] graph = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}
