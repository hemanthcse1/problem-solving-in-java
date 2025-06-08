package examples.daily.june;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbersGenerator {
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
        LexicographicalNumbersGenerator generator = new LexicographicalNumbersGenerator();
        int n = 50;
        List<Integer> result = generator.lexicalOrder(n);
        System.out.println("Lexicographical order from 1 to " + n + ":");
        System.out.println(result);
    }
}
