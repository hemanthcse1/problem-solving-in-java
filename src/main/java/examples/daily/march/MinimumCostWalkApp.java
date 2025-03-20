package examples.daily.march;

import java.util.Arrays;

public class MinimumCostWalkApp {

    public static void main(String[] args) {

        MinimumCostWalkApp minimumCostWalkApp = new MinimumCostWalkApp();

        int n = 5;
        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
        int[][] query = {{0, 3}, {3, 4}};

        int[] result = minimumCostWalkApp.minimumCost(n, edges, query);
        System.out.println(Arrays.toString(result));
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1], edge[2]);
        }
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int u = query[i][0], v = query[i][1];
            if (uf.find(u) != uf.find(v)) res[i] = -1;
            else res[i] = uf.getCost(u);
        }
        return res;
    }

    class UnionFind {
        int[] parent;
        int[] cost;

        UnionFind(int n) {
            parent = new int[n];
            cost = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                cost[i] = -1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                int p = find(parent[x]);
                cost[x] &= cost[parent[x]];
                parent[x] = p;
            }
            return parent[x];
        }

        void union(int x, int y, int w) {
            int px = find(x), py = find(y);
            if (px != py) {
                parent[px] = py;
                cost[py] = (cost[px] == -1 ? w : cost[px] & w) & (cost[py] == -1 ? w : cost[py]);
            } else {
                cost[py] &= w;
            }
        }

        int getCost(int x) {
            return cost[find(x)];
        }
    }
}
