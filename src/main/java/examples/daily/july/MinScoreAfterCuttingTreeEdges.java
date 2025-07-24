package examples.daily.july;

import java.util.*;

public class MinScoreAfterCuttingTreeEdges {

    public static void main(String[] args) {
        MinScoreAfterCuttingTreeEdges solution = new MinScoreAfterCuttingTreeEdges();

        int[] nums = {1, 5, 5, 4, 11};
        int[][] edges = {
                {0, 1},
                {1, 2},
                {1, 3},
                {3, 4}
        };

        int result = solution.minimumScore(nums, edges);
        System.out.println("Minimum Score after removing two edges: " + result);
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        int totalXor = getXor(nums);
        int[] subXors = nums.clone();
        List<Integer>[] tree = new List[n];
        Set<Integer>[] children = new Set[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            children[i] = new HashSet<>(Arrays.asList(i));
        }

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        dfs(tree, 0, -1, subXors, children);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            if (children[a].contains(b)) { int t = a; a = b; b = t; }
            for (int j = 0; j < i; j++) {
                int c = edges[j][0], d = edges[j][1];
                if (children[c].contains(d)) { int t = c; c = d; d = t; }
                int[] parts;
                if (a != c && children[a].contains(c))
                    parts = new int[]{subXors[c], subXors[a] ^ subXors[c], totalXor ^ subXors[a]};
                else if (a != c && children[c].contains(a))
                    parts = new int[]{subXors[a], subXors[c] ^ subXors[a], totalXor ^ subXors[c]};
                else
                    parts = new int[]{subXors[a], subXors[c], totalXor ^ subXors[a] ^ subXors[c]};
                ans = Math.min(ans, Arrays.stream(parts).max().getAsInt() - Arrays.stream(parts).min().getAsInt());
            }
        }
        return ans;
    }

    private Pair<Integer, Set<Integer>> dfs(List<Integer>[] tree, int u, int p, int[] subXors, Set<Integer>[] children) {
        for (int v : tree[u]) {
            if (v == p) continue;
            Pair<Integer, Set<Integer>> res = dfs(tree, v, u, subXors, children);
            subXors[u] ^= res.getKey();
            children[u].addAll(res.getValue());
        }
        return new Pair<>(subXors[u], children[u]);
    }

    private int getXor(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }
}
