package examples.daily.july;

import java.util.Arrays;

public class MaxMatchingPlayersTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0, count = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaxMatchingPlayersTrainers solution = new MaxMatchingPlayersTrainers();
        System.out.println(solution.matchPlayersAndTrainers(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8})); //  2
        System.out.println(solution.matchPlayersAndTrainers(new int[]{1, 1, 1}, new int[]{10})); //  1
    }
}
