package examples.daily.february;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilitiesAlternative {
    public int numTilePossibilities(String tiles) {
        Set<String> resultSet = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        backtrack(tiles, "", used, resultSet);
        return resultSet.size();
    }

    private void backtrack(String tiles, String current, boolean[] used, Set<String> resultSet) {
        if (!current.isEmpty()) resultSet.add(current);

        for (int i = 0; i < tiles.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            backtrack(tiles, current + tiles.charAt(i), used, resultSet);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        LetterTilePossibilitiesAlternative solution = new LetterTilePossibilitiesAlternative();
        System.out.println(solution.numTilePossibilities("AAB"));    //  8
        System.out.println(solution.numTilePossibilities("AAABBC")); //  188
        System.out.println(solution.numTilePossibilities("V"));      //  1
    }
}
