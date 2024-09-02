package examples.interviewquestions.strings.easy;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequence {

    public List<String> findLongestAlternatingSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        result.add(words[0]);

        for (int i = 1; i < n; i++) {
            if (groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestUnequalAdjacentGroupsSubsequence solution = new LongestUnequalAdjacentGroupsSubsequence();


        String[] words1 = {"apple", "banana", "cherry", "date", "elderberry"};
        int[] groups1 = {0, 1, 0, 1, 0};
        System.out.println(solution.findLongestAlternatingSubsequence(words1, groups1));


        String[] words2 = {"apple", "banana", "cherry", "date"};
        int[] groups2 = {0, 0, 1, 1};
        System.out.println(solution.findLongestAlternatingSubsequence(words2, groups2));


        String[] words3 = {"apple", "banana", "cherry", "date", "elderberry"};
        int[] groups3 = {1, 1, 1, 1, 1};
        System.out.println(solution.findLongestAlternatingSubsequence(words3, groups3));

    }
}
