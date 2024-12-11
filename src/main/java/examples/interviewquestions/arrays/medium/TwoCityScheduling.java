package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class TwoCityScheduling {

    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> (c1[0] - c1[1]) - (c2[0] - c2[1]));
        int n = costs.length / 2;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += costs[i][0];
        }
        for (int i = n; i < 2*n; i++) {
            total += costs[i][1];
        }
        return total;
    }

    public static void main(String[] args) {

        int[][] costs1 = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(twoCitySchedCost(costs1));

        int[][] costs2 = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.out.println(twoCitySchedCost(costs2));

        int[][] costs3 = {{515,563},{451,713},{537,709},{343,819},{855,779},{457,60},{650,359},{631,42}};
        System.out.println(twoCitySchedCost(costs3));
    }
}
