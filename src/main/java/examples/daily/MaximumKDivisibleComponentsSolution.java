package examples.daily;

import java.util.ArrayList;
import java.util.List;

public class MaximumKDivisibleComponentsSolution {

    private List<List<Integer>> adj;
    private int[] values;
    private int k;
    private int count;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.values = values;
        this.k = k;
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        count = 0;
        dfs(0, -1);
        return count + 1;
    }

    private long dfs(int node, int parent){
        long total = values[node];
        for(int neighbor : adj.get(node)){
            if(neighbor != parent){
                total += dfs(neighbor, node);
            }
        }
        if(total % k == 0 && node != 0){
            count++;
            return 0;
        }
        return total;
    }

    public static void main(String[] args) {
        MaximumKDivisibleComponentsSolution obj = new MaximumKDivisibleComponentsSolution();

        int n1 = 5;
        int[][] edges1 = {{0,2},{1,2},{1,3},{2,4}};
        int[] values1 = {1,8,1,4,4};
        int k1 = 6;
        System.out.println(obj.maxKDivisibleComponents(n1, edges1, values1, k1));

        int n2 = 7;
        int[][] edges2 = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int[] values2 = {3,0,6,1,5,2,1};
        int k2 = 3;
        System.out.println(obj.maxKDivisibleComponents(n2, edges2, values2, k2));

        int n3 = 4;
        int[][] edges3 = {{0,1},{1,2},{1,3}};
        int[] values3 = {3,3,0,0};
        int k3 = 6;
        System.out.println(obj.maxKDivisibleComponents(n3, edges3, values3, k3));
    }
}
