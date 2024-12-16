package examples.interviewquestions.strings.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDeletionsToMakeStringKSpecial {

    public int minDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> frequencies = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) frequencies.add(f);
        }

        if (frequencies.isEmpty()) return 0;

        Collections.sort(frequencies);
        int n = frequencies.size();

        int maxFreq = frequencies.get(n - 1);
        int minDeletions = Integer.MAX_VALUE;

        for (int low = 0; low <= maxFreq; low++) {
            int high = low + k;
            int deletions = 0;
            for (int f : frequencies) {
                if (f < low) {
                    deletions += f;
                } else if (f > high) {
                    deletions += (f - high);
                }
            }
            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringKSpecial solver = new MinimumDeletionsToMakeStringKSpecial();

        String word1 = "aabcaba";
        int k1 = 0;
        System.out.println(solver.minDeletions(word1, k1));

        String word2 = "dabdcbdcdcd";
        int k2 = 2;
        System.out.println(solver.minDeletions(word2, k2));

        String word3 = "aaabaaa";
        int k3 = 2;
        System.out.println(solver.minDeletions(word3, k3));
    }
}
