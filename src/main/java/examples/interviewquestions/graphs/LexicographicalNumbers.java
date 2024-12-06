package examples.interviewquestions.graphs;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int current = 1;

        for (int i = 0; i < n; i++) {
            result.add(current);

            if (current * 10 <= n) {
                current *= 10;
            } else {
                while (current % 10 == 9 || current + 1 > n) {
                    current /= 10;
                }
                current++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LexicographicalNumbers solution = new LexicographicalNumbers();

        int n1 = 13;
        System.out.println(solution.lexicalOrder(n1));

        int n2 = 2;
        System.out.println(solution.lexicalOrder(n2));
    }
}
