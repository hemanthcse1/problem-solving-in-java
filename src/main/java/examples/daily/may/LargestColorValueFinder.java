package examples.daily.may;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueFinder {

    public static void main(String[] args) {
        LargestColorValueFinder solution = new LargestColorValueFinder();

        String colors1 = "abaca";
        int[][] edges1 = {{0,1},{0,2},{2,3},{3,4}};

        String colors2 = "a";
        int[][] edges2 = {{0,0}};

        System.out.println(solution.largestPathValue(colors1, edges1)); // Output: 3
        System.out.println(solution.largestPathValue(colors2, edges2)); // Output: -1
    }
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[][] colorCount = new int[n][26];
        int visited = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            int colorIndex = colors.charAt(node) - 'a';
            colorCount[node][colorIndex]++;
            result = Math.max(result, colorCount[node][colorIndex]);

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    colorCount[neighbor][c] = Math.max(colorCount[neighbor][c], colorCount[node][c]);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return visited == n ? result : -1;
    }
}
