package examples.interviewquestions.graphs.medium;

public class CityWithSmallestNeighbors {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int INF = 1000000;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }
        for(int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        int result = -1;
        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=0;j<n;j++) {
                if(i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if(count < minCount || (count == minCount && i > result)) {
                minCount = count;
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CityWithSmallestNeighbors solver = new CityWithSmallestNeighbors();

        int n1 = 4;
        int[][] edges1 = {
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };
        int distanceThreshold1 = 4;
        int result1 = solver.findTheCity(n1, edges1, distanceThreshold1);
        System.out.println("Output for Example 1: " + result1);

        int n2 = 5;
        int[][] edges2 = {
                {0, 1, 2},
                {0, 4, 8},
                {1, 2, 3},
                {1, 4, 2},
                {2, 3, 1},
                {3, 4, 1}
        };
        int distanceThreshold2 = 2;
        int result2 = solver.findTheCity(n2, edges2, distanceThreshold2);
        System.out.println("Output for Example 2: " + result2);
    }
}
