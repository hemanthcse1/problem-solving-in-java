package examples.interviewquestions.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int card : deck) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        int gcd = -1;
        for (int freq : count.values()) {
            if (gcd == -1) {
                gcd = freq;
            } else {
                gcd = gcd(gcd, freq);
            }
        }

        return gcd > 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        XOfAKindInADeckOfCards solver = new XOfAKindInADeckOfCards();
        System.out.println(solver.hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1}));
        System.out.println(solver.hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));
    }
}
