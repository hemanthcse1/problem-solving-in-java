package examples.interviewquestions.strings.medium;

import java.util.Arrays;

public class MinimumPushesToTypeWordII {

    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);
        int keys = 8;
        int pushes = 0;
        int layer = 1;
        int index = 25;

        while (index >= 0 && freq[index] > 0) {
            for (int i = 0; i < keys && index >= 0; i++) {
                if (freq[index] > 0) {
                    pushes += freq[index] * layer;
                }
                index--;
            }
            layer++;
        }

        return pushes;
    }

    public static void main(String[] args) {
        MinimumPushesToTypeWordII solver = new MinimumPushesToTypeWordII();

        String word1 = "abcde";
        System.out.println(solver.minimumPushes(word1));

        String word2 = "xyzxyzxyzxyz";
        System.out.println(solver.minimumPushes(word2));

        String word3 = "aabbccddeeffgghhiiiiii";
        System.out.println(solver.minimumPushes(word3));
    }
}
