package examples.interviewquestions.graphs.medium;

import java.util.HashMap;
import java.util.Map;

public class RemoveStones {

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[][] stones1 = {
                {0,0},{0,1},{1,0},{1,2},{2,1},{2,2}
        };
        int result1 = solver.removeStones(stones1);
        System.out.println("Output for Example 1: " + result1);


        int[][] stones2 = {
                {0,0},{0,2},{1,1},{2,0},{2,2}
        };
        int result2 = solver.removeStones(stones2);
        System.out.println("Output for Example 2: " + result2);


        int[][] stones3 = {
                {0,0}
        };
        int result3 = solver.removeStones(stones3);
        System.out.println("Output for Example 3: " + result3);


        int[][] stones4 = {
                {0,0},{0,3},{1,1},{1,3},{2,2},{2,3}
        };
        int result4 = solver.removeStones(stones4);
        System.out.println("Output for Additional Test Case: " + result4);
    }

    static class Solution {
        public int removeStones(int[][] stones) {
            UnionFind uf = new UnionFind();
            for (int[] stone : stones) {
                uf.union(stone[0] + 10001, stone[1]);
            }
            return stones.length - uf.getCount();
        }

        static class UnionFind {
            private Map<Integer, Integer> parent;
            private int count;

            public UnionFind() {
                parent = new HashMap<>();
                count = 0;
            }

            public int find(int x) {
                if (!parent.containsKey(x)) {
                    parent.put(x, x);
                    count++;
                }
                if (parent.get(x) != x) {
                    parent.put(x, find(parent.get(x)));
                }
                return parent.get(x);
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX != rootY) {
                    parent.put(rootX, rootY);
                    count--;
                }
            }

            public int getCount() {
                return count;
            }
        }
    }
}
