package examples.daily.february;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostProfitablePathInTree {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;


        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        findBobPath(graph, bob, -1, 0, bobTime);

        return dfsAlice(graph, 0, -1, 0, 0, bobTime, amount);
    }

    private boolean findBobPath(List<Integer>[] graph, int node, int parent, int time, int[] bobTime) {
        bobTime[node] = time;
        if (node == 0) return true;

        for (int neighbor : graph[node]) {
            if (neighbor != parent && findBobPath(graph, neighbor, node, time + 1, bobTime)) {
                return true;
            }
        }

        bobTime[node] = Integer.MAX_VALUE;
        return false;
    }

    private int dfsAlice(List<Integer>[] graph, int node, int parent, int time, int profit, int[] bobTime, int[] amount) {

        if (time < bobTime[node]) {
            profit += amount[node];
        } else if (time == bobTime[node]) {
            profit += amount[node] / 2;
        }

        boolean isLeaf = true;
        int maxProfit = Integer.MIN_VALUE;
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                isLeaf = false;
                maxProfit = Math.max(maxProfit, dfsAlice(graph, neighbor, node, time + 1, profit, bobTime, amount));
            }
        }

        return isLeaf ? profit : maxProfit;
    }

    public static void main(String[] args) {
        MostProfitablePathInTree solution = new MostProfitablePathInTree();


        int[][] edges = {{0,1},{1,2},{2,3}};
        int bob = 3;
        int[] amount = {-5644,-6018,1188,-8502};
        System.out.println(solution.mostProfitablePath(edges, bob, amount)); //  -11662
    }
}
