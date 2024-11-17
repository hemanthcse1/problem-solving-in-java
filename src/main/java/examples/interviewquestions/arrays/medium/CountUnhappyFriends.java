package examples.interviewquestions.arrays.medium;

public class CountUnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rank = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                rank[i][preferences[i][j]] = j;
            }
        }

        int[] pair = new int[n];
        for (int[] p : pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }

        int unhappyCount = 0;

        for (int x = 0; x < n; x++) {
            int y = pair[x];
            for (int u : preferences[x]) {
                if (rank[x][u] < rank[x][y]) {
                    int v = pair[u];
                    if (rank[u][x] < rank[u][v]) {
                        unhappyCount++;
                        break;
                    }
                }
            }
        }

        return unhappyCount;
    }

    public static void main(String[] args) {
        CountUnhappyFriends sol = new CountUnhappyFriends();
        System.out.println(sol.unhappyFriends(4,
                new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}},
                new int[][]{{0, 1}, {2, 3}}));

        System.out.println(sol.unhappyFriends(2,
                new int[][]{{1}, {0}},
                new int[][]{{1, 0}}));

        System.out.println(sol.unhappyFriends(4,
                new int[][]{{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}},
                new int[][]{{1, 3}, {0, 2}}));
    }
}
