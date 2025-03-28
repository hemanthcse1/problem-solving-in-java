package examples.daily.march;

import java.util.*;

public class GridQueryPointsCalculator {

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[queries.length];
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        List<int[]> queryWithIndex = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            queryWithIndex.add(new int[]{queries[i], i});
        }
        Collections.sort(queryWithIndex, Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        int count = 0;
        int idx = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (!pq.isEmpty() && idx < queryWithIndex.size()) {
            int limit = queryWithIndex.get(idx)[0];
            while (!pq.isEmpty() && pq.peek()[2] < limit) {
                int[] curr = pq.poll();
                count++;
                int x = curr[0], y = curr[1];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                        pq.offer(new int[]{nx, ny, grid[nx][ny]});
                        visited[nx][ny] = true;
                    }
                }
            }
            map.put(limit, count);
            idx++;
        }

        for (int i = 0; i < queries.length; i++) {
            res[i] = map.floorEntry(queries[i]) != null ? map.floorEntry(queries[i]).getValue() : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        GridQueryPointsCalculator calculator = new GridQueryPointsCalculator();

        int[][] grid1 = {{1,2,3},{2,5,7},{3,5,1}};
        int[] queries1 = {5, 6, 2};
        System.out.println(Arrays.toString(calculator.maxPoints(grid1, queries1))); //  [5, 8, 1]

        int[][] grid2 = {{5,2,1},{1,1,2}};
        int[] queries2 = {3};
        System.out.println(Arrays.toString(calculator.maxPoints(grid2, queries2))); //  [0]
    }
}
