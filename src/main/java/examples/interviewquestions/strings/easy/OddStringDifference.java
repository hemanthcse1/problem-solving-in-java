package examples.interviewquestions.strings.easy;

import java.util.Arrays;

public class OddStringDifference {

    public String oddString(String[] words) {
        int[] diff1 = getDifferenceArray(words[0]);
        int[] diff2 = getDifferenceArray(words[1]);
        int[] diff3 = getDifferenceArray(words[2]);

        if (Arrays.equals(diff1, diff2)) {
            for (int i = 2; i < words.length; i++) {
                if (!Arrays.equals(getDifferenceArray(words[i]), diff1)) {
                    return words[i];
                }
            }
        } else if (Arrays.equals(diff1, diff3)) {
            return words[1];
        } else {
            return words[0];
        }

        return null;
    }

    private int[] getDifferenceArray(String word) {
        int[] diff = new int[word.length() - 1];
        for (int i = 0; i < word.length() - 1; i++) {
            diff[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return diff;
    }

    public static void main(String[] args) {
        OddStringDifference solution = new OddStringDifference();

        String[] words1 = {"adc", "wzy", "abc"};
        System.out.println(solution.oddString(words1));
    }
}
