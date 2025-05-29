package examples.daily.may;

import java.util.ArrayList;
import java.util.List;

public class TargetNodeParityConnector {
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

        TargetNodeParityConnector targetNodeParityConnector = new TargetNodeParityConnector();
        int[] result = targetNodeParityConnector.maxTargetNodes(edges1, edges2);

        System.out.print("Maximum target nodes for each node in Tree 1: ");
        for (int count : result) {
            System.out.print(count + " ");
        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<Integer>[] tree1 = buildGraph(edges1);
        List<Integer>[] tree2 = buildGraph(edges2);

        int n = tree1.length, m = tree2.length;
        int[] color1 = new int[n];
        int[] color2 = new int[m];
        int[] count1 = new int[2];
        int[] count2 = new int[2];

        dfs(tree2, 0, -1, color2, 0, count2);
        dfs(tree1, 0, -1, color1, 0, count1);

        int maxCountInTree2 = Math.max(count2[0], count2[1]);

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = maxCountInTree2 + count1[color1[i]];
        }

        return result;
    }

    private List<Integer>[] buildGraph(int[][] edges) {
        int size = edges.length + 1;
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

    private void dfs(List<Integer>[] graph, int node, int parent, int[] color, int currentColor, int[] count) {
        color[node] = currentColor;
        count[currentColor]++;
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                dfs(graph, neighbor, node, color, currentColor ^ 1, count);
            }
        }
    }
}
