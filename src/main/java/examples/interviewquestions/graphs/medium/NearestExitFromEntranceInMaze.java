package examples.interviewquestions.graphs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = { {-1,0}, {1,0}, {0,-1}, {0,1} };
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int startRow = entrance[0];
        int startCol = entrance[1];
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                        continue;
                    }
                    if (maze[newRow][newCol] == '+' || visited[newRow][newCol]) {
                        continue;
                    }
                    if (isExit(newRow, newCol, m, n)) {
                        return steps + 1;
                    }
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean isExit(int row, int col, int m, int n) {
        return row == 0 || row == m - 1 || col == 0 || col == n - 1;
    }

    public static void main(String[] args) {
        NearestExitFromEntranceInMaze solver = new NearestExitFromEntranceInMaze();

        char[][] maze1 = {
                { '+', '+', '.', '+' },
                { '.', '.', '.', '+' },
                { '+', '+', '+', '.' }
        };
        int[] entrance1 = {1, 2};
        System.out.println("Example 1 Output: " + solver.nearestExit(maze1, entrance1));

        char[][] maze2 = {
                { '+', '+', '+' },
                { '.', '.', '.' },
                { '+', '+', '+' }
        };
        int[] entrance2 = {1, 0};
        System.out.println("Example 2 Output: " + solver.nearestExit(maze2, entrance2));

        char[][] maze3 = {
                { '.', '+' }
        };
        int[] entrance3 = {0, 0};
        System.out.println("Example 3 Output: " + solver.nearestExit(maze3, entrance3));

        char[][] maze4 = {
                { '.', '.', '.', '.' },
                { '+', '+', '.', '+' },
                { '.', '.', '.', '.' },
                { '.', '+', '+', '.' }
        };
        int[] entrance4 = {2, 2};
        System.out.println("Additional Test Case Output: " + solver.nearestExit(maze4, entrance4));
    }
}
