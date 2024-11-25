package examples.daily;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }

        String startState = start.toString();
        if (startState.equals(target)) return 0;

        int[][] moves = {
                {1, 3},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startState);
        visited.add(startState);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return steps;

                int zeroIndex = current.indexOf('0');
                for (int move : moves[zeroIndex]) {
                    String nextState = swap(current, zeroIndex, move);
                    if (!visited.contains(nextState)) {
                        queue.add(nextState);
                        visited.add(nextState);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private String swap(String state, int i, int j) {
        char[] chars = state.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        SlidingPuzzle solution = new SlidingPuzzle();

        int[][] board1 = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(solution.slidingPuzzle(board1));

        int[][] board2 = {{1, 2, 3}, {5, 4, 0}};
        System.out.println(solution.slidingPuzzle(board2));
    }
}
