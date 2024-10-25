package examples.interviewquestions.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class MagicalString {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        List<Integer> magical = new ArrayList<>();
        magical.add(1);
        magical.add(2);
        magical.add(2);

        int countOnes = 1;
        int i = 2;
        int num = 1;

        while (magical.size() < n) {
            int size = magical.get(i);
            for (int j = 0; j < size; j++) {
                magical.add(num);
                if (num == 1 && magical.size() <= n) countOnes++;
            }
            num = num == 1 ? 2 : 1;
            i++;
        }

        return countOnes;
    }

    public static void main(String[] args) {
        MagicalString solution = new MagicalString();

        System.out.println(solution.magicalString(6));
        System.out.println(solution.magicalString(1));
        System.out.println(solution.magicalString(10));
    }
}
