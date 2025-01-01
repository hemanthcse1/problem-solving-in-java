package examples.interviewquestions.graphs.medium;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected1));

        int[][] isConnected2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected2));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int city = 0; city < n; city++) {
            if (!visited[city]) {
                provinces++;
                dfs(isConnected, visited, city);
            }
        }
        return provinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int currentCity) {
        visited[currentCity] = true;
        for (int nextCity = 0; nextCity < isConnected.length; nextCity++) {
            if (isConnected[currentCity][nextCity] == 1 && !visited[nextCity]) {
                dfs(isConnected, visited, nextCity);
            }
        }
    }
}
