package examples.interviewquestions.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class CountWinners {
    public int countWinners(int n, int[][] pick) {
        Map<Integer, Integer>[] colorCounts = new HashMap[n];

        for (int i = 0; i < n; i++) {
            colorCounts[i] = new HashMap<>();
        }

        for (int[] pk : pick) {
            int player = pk[0];
            int color = pk[1];
            colorCounts[player].put(color, colorCounts[player].getOrDefault(color, 0) + 1);
        }

        int winnerCount = 0;
        for (int i = 0; i < n; i++) {
            for (int count : colorCounts[i].values()) {
                if (count >= i + 1) {
                    winnerCount++;
                    break;
                }
            }
        }

        return winnerCount;
    }

    public static void main(String[] args) {
        CountWinners sol = new CountWinners();
        int[][] picks1 = {{0,0}, {1,0}, {1,0}, {2,1}, {2,1}, {2,0}};
        System.out.println(sol.countWinners(4, picks1));

        int[][] picks2 = {{1,1}, {1,2}, {1,3}, {1,4}};
        System.out.println(sol.countWinners(5, picks2));

        int[][] picks3 = {{1,1}, {2,4}, {2,4}, {2,4}};
        System.out.println(sol.countWinners(5, picks3));
    }
}
