package examples.daily.march;

import java.util.*;

public class ShortestPathCounter {

    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long time = curr[1];

            if (time > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0], t = neighbor[1];
                long newDist = time + t;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new long[]{next, newDist});
                } else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }

    public static void main(String[] args) {
        ShortestPathCounter shortestPathCounter = new ShortestPathCounter();

        int n = 7;
        int[][] roads = {
                {0,6,7},{0,1,2},{1,2,3},{1,3,3},
                {6,3,3},{3,5,1},{6,5,1},{2,5,1},
                {0,4,5},{4,6,2}
        };

        int numberOfWays = shortestPathCounter.countPaths(n, roads);
        System.out.println("Number of ways: " + numberOfWays);
    }


}
