package examples.interviewquestions.strings.medium;

import java.util.Arrays;
import java.util.Comparator;

public class FindAndReplaceInString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        Integer[] sortedIndices = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedIndices[i] = i;
        }

        Arrays.sort(sortedIndices, Comparator.comparingInt(i -> -indices[i]));

        StringBuilder sb = new StringBuilder(s);

        for (int i : sortedIndices) {
            int index = indices[i];
            String source = sources[i];
            String target = targets[i];

            if (s.startsWith(source, index)) {
                sb.replace(index, index + source.length(), target);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FindAndReplaceInString solution = new FindAndReplaceInString();

        String s1 = "abcd";
        int[] indices1 = {0, 2};
        String[] sources1 = {"a", "cd"};
        String[] targets1 = {"eee", "ffff"};
        System.out.println(solution.findReplaceString(s1, indices1, sources1, targets1));

        String s2 = "abcd";
        int[] indices2 = {0, 2};
        String[] sources2 = {"ab", "ec"};
        String[] targets2 = {"eee", "ffff"};
        System.out.println(solution.findReplaceString(s2, indices2, sources2, targets2));
    }
}
