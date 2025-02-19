package examples.daily.february;

import java.util.ArrayList;
import java.util.List;

public class HappyString {

    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        backtrack(n, "", happyStrings);


        return k > happyStrings.size() ? "" : happyStrings.get(k - 1);
    }

    private void backtrack(int n, String current, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != ch) {
                backtrack(n, current + ch, happyStrings);
            }
        }
    }

    public static void main(String[] args) {
        HappyString solution = new HappyString();

        System.out.println(solution.getHappyString(1, 3)); //  "c"
        System.out.println(solution.getHappyString(1, 4)); //  ""
        System.out.println(solution.getHappyString(3, 9)); //  "cab"
    }
}
