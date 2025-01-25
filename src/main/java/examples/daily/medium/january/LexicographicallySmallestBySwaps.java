package examples.daily.medium.january;

import java.util.*;

public class LexicographicallySmallestBySwaps {
    private int[] parent, rank;

    public int[] makeLexSmallest(int[] nums, int limit) {
        int n = nums.length;
        int[][] valueIndexPairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            valueIndexPairs[i][0] = nums[i];
            valueIndexPairs[i][1] = i;
        }
        Arrays.sort(valueIndexPairs, Comparator.comparingInt(a -> a[0]));

        initUnionFind(n);

        for (int i = 1; i < n; i++) {
            long diff = (long) valueIndexPairs[i][0] - valueIndexPairs[i - 1][0];
            if (diff <= limit) {
                union(valueIndexPairs[i][1], valueIndexPairs[i - 1][1]);
            }
        }

        Map<Integer, List<Integer>> compMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            compMap.putIfAbsent(root, new ArrayList<>());
            compMap.get(root).add(i);
        }

        for (List<Integer> indices : compMap.values()) {
            Collections.sort(indices);
            int[] vals = new int[indices.size()];
            for (int i = 0; i < indices.size(); i++) {
                vals[i] = nums[indices.get(i)];
            }
            Arrays.sort(vals);
            for (int i = 0; i < indices.size(); i++) {
                nums[indices.get(i)] = vals[i];
            }
        }
        return nums;
    }

    private void initUnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return;
        if (rank[rx] < rank[ry]) {
            parent[rx] = ry;
        } else if (rank[rx] > rank[ry]) {
            parent[ry] = rx;
        } else {
            parent[ry] = rx;
            rank[rx]++;
        }
    }

    public static void main(String[] args) {
        LexicographicallySmallestBySwaps solver = new LexicographicallySmallestBySwaps();

        int[] nums1 = {1,5,3,9,8};
        System.out.println(Arrays.toString(
                solver.makeLexSmallest(nums1, 2)
        ));

        int[] nums2 = {1,7,6,18,2,1};
        System.out.println(Arrays.toString(
                solver.makeLexSmallest(nums2, 3)
        ));

        int[] nums3 = {1,7,28,19,10};
        System.out.println(Arrays.toString(
                solver.makeLexSmallest(nums3, 3)
        ));
    }
}
