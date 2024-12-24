package examples.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMinDiameterAfterMergingTrees {

    public int findMinDiameterAfterMergingTrees(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        int diameter1 = computeDiameter(n, edges1);
        int diameter2 = computeDiameter(m, edges2);

        int height1 = (int)Math.ceil(diameter1 / 2.0);
        int height2 = (int)Math.ceil(diameter2 / 2.0);

        int newDiameter = Math.max(diameter1, Math.max(diameter2, height1 + 1 + height2));

        return newDiameter;
    }

    private int computeDiameter(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        BFSResult firstBFS = bfs(0, adj, n);
        BFSResult secondBFS = bfs(firstBFS.farthestNode, adj, n);

        return secondBFS.maxDistance;
    }

    private BFSResult bfs(int start, List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;

        int farthestNode = start;
        int maxDist = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int neighbor : adj.get(current)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                    if(distance[neighbor] > maxDist) {
                        maxDist = distance[neighbor];
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return new BFSResult(farthestNode, maxDist);
    }

    private class BFSResult {
        int farthestNode;
        int maxDistance;

        BFSResult(int farthestNode, int maxDistance) {
            this.farthestNode = farthestNode;
            this.maxDistance = maxDistance;
        }
    }

    public static void main(String[] args) {
        FindMinDiameterAfterMergingTrees solution = new FindMinDiameterAfterMergingTrees();

        int[][] edges1_1 = {{0,1},{0,2},{0,3}};
        int[][] edges2_1 = {{0,1}};
        System.out.println(solution.findMinDiameterAfterMergingTrees(edges1_1, edges2_1));

        int[][] edges1_2 = {{0,1},{0,2},{0,3},{2,4},{2,5},{3,6},{2,7}};
        int[][] edges2_2 = {{0,1},{0,2},{0,3},{2,4},{2,5},{3,6},{2,7}};
        System.out.println(solution.findMinDiameterAfterMergingTrees(edges1_2, edges2_2));

    }
}
