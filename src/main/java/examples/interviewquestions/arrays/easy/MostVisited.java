package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class MostVisited {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> result = new ArrayList<>();
        int start = rounds[0];
        int end = rounds[rounds.length - 1];

        if (start <= end) {
            for (int i = start; i <= end; i++) {
                result.add(i);
            }
        } else {
            for (int i = start; i <= n; i++) {
                result.add(i);
            }
            for (int i = 1; i <= end; i++) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MostVisited solution = new MostVisited();

        int[] rounds1 = {1, 3, 1, 2};
        System.out.println(solution.mostVisited(4, rounds1));

        int[] rounds2 = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        System.out.println(solution.mostVisited(2, rounds2));

        int[] rounds3 = {1, 3, 5, 7};
        System.out.println(solution.mostVisited(7, rounds3));
    }
}
