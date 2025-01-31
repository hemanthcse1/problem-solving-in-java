package examples.daily.medium.january;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestIsland {

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandId = 2;
        int maxIsland = 0;


        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int size = dfs(grid, r, c, islandId);
                    islandSize.put(islandId, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandId++;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> seenIslands = new HashSet<>();
                    int newSize = 1;

                    for (int[] d : directions) {
                        int nr = r + d[0], nc = c + d[1];
                        if (isValid(grid, nr, nc) && grid[nr][nc] > 1) {
                            int id = grid[nr][nc];
                            if (seenIslands.add(id)) {
                                newSize += islandSize.get(id);
                            }
                        }
                    }

                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }


        return maxIsland == 0 ? n * n : maxIsland;
    }

    private int dfs(int[][] grid, int r, int c, int islandId) {
        if (!isValid(grid, r, c) || grid[r][c] != 1) return 0;

        grid[r][c] = islandId;
        int size = 1;

        for (int[] d : directions) {
            size += dfs(grid, r + d[0], c + d[1], islandId);
        }

        return size;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        LargestIsland solution = new LargestIsland();

        System.out.println(solution.largestIsland(new int[][]{{1, 0}, {0, 1}})); //  3
        System.out.println(solution.largestIsland(new int[][]{{1, 1}, {1, 0}})); //  4
        System.out.println(solution.largestIsland(new int[][]{{1, 1}, {1, 1}})); //  4
    }
}
