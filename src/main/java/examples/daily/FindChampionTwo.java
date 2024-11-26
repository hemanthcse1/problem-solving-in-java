package examples.daily;

import java.util.*;

public class FindChampionTwo {

    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
            inDegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int champion = -1;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return -1;
            }
            champion = queue.poll();
            if (graph.containsKey(champion)) {
                for (int neighbor : graph.get(champion)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != champion && inDegree[i] > 0) {
                return -1;
            }
        }

        return champion;
    }

    public static void main(String[] args) {
        FindChampionTwo fc = new FindChampionTwo();
        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}};
        System.out.println(fc.findChampion(n1, edges1));
        int n2 = 4;
        int[][] edges2 = {{0, 2}, {1, 3}, {1, 2}};
        System.out.println(fc.findChampion(n2, edges2));
    }
}
