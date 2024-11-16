package examples.interviewquestions.hashmaps.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> powerfulInts = new HashSet<>();

        for (int xi = 1; xi <= bound; xi = (x == 1) ? bound + 1 : xi * x) {

            for (int yj = 1; xi + yj <= bound; yj = (y == 1) ? bound + 1 : yj * y) {
                powerfulInts.add(xi + yj);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(powerfulInts);
    }

    public static void main(String[] args) {
        PowerfulIntegers sol = new PowerfulIntegers();
        System.out.println(sol.powerfulIntegers(2, 3, 10));
        System.out.println(sol.powerfulIntegers(3, 5, 15));
    }
}
