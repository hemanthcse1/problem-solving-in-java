package examples.interviewquestions.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {
    private List<String> combinations;
    private int index;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList<>();
        generateCombinations(characters, combinationLength, 0, new StringBuilder());
        index = 0;
    }

    private void generateCombinations(String characters, int combinationLength, int start, StringBuilder combination) {
        if (combination.length() == combinationLength) {
            combinations.add(combination.toString());
            return;
        }

        for (int i = start; i < characters.length(); i++) {
            combination.append(characters.charAt(i));
            generateCombinations(characters, combinationLength, i + 1, combination);
            combination.deleteCharAt(combination.length() - 1); // backtrack
        }
    }

    public String next() {
        return combinations.get(index++);
    }

    public boolean hasNext() {
        return index < combinations.size();
    }

    public static void main(String[] args) {
        CombinationIterator itr = new CombinationIterator("abc", 2);
        System.out.println(itr.next());
        System.out.println(itr.hasNext());
        System.out.println(itr.next());
        System.out.println(itr.hasNext());
        System.out.println(itr.next());
        System.out.println(itr.hasNext());
    }
}
