package examples.daily.medium.january;

public class RedundantConnections {

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            if (find(parent, u) == find(parent, v)) {
                return edge;
            }
            union(parent, u, v);
        }

        return new int[]{};
    }

    private static int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    private static void union(int[] parent, int u, int v) {
        int rootU = find(parent, u);
        int rootV = find(parent, v);
        if (rootU != rootV) {
            parent[rootV] = rootU;
        }
    }

    public static void main(String[] args) {

        int[][] edges1 = {{1,2},{1,3},{2,3}};
        System.out.println(java.util.Arrays.toString(findRedundantConnection(edges1))); //  [2,3]

        int[][] edges2 = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(java.util.Arrays.toString(findRedundantConnection(edges2))); //  [1,4]
    }
}
