package examples.interviewquestions.graphs.medium;

import java.util.*;

public class ReorderRoutesToCityZero {

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        Set<String> directed = new HashSet<>();
        for(int[] c : connections) {
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(c[0]);
            directed.add(c[0] + "#" + c[1]);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        visited[0] = true;
        stack.push(0);
        int res = 0;
        while(!stack.isEmpty()) {
            int u = stack.pop();
            for(int v : adj.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    if(directed.contains(u + "#" + v)) {
                        res++;
                    }
                    stack.push(v);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReorderRoutesToCityZero sol = new ReorderRoutesToCityZero();
        System.out.println(sol.minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
        System.out.println(sol.minReorder(5, new int[][]{{1,0},{1,2},{3,2},{3,4}}));
        System.out.println(sol.minReorder(3, new int[][]{{1,0},{2,0}}));
    }
}
