package examples.daily.june;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDeletionsMain {

    public static void main(String[] args) {
        MinimumDeletionsMain minimumDeletionsMain = new MinimumDeletionsMain();

        String word1 = "aabbcc";
        int k1 = 1;
        System.out.println("Minimum deletions (Test 1): " + minimumDeletionsMain.minimumDeletions(word1, k1)); // 0

        String word2 = "aabccc";
        int k2 = 1;
        System.out.println("Minimum deletions (Test 2): " + minimumDeletionsMain.minimumDeletions(word2, k2)); //  1
    }

    public int minimumDeletions(String word, int k) {
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
}
