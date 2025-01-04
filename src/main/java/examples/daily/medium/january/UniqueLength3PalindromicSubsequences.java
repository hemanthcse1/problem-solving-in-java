package examples.daily.medium.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        List<Integer>[] positions = new List[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            positions[c - 'a'].add(i);
        }

        int[] firstIndex = new int[26];
        int[] lastIndex  = new int[26];
        Arrays.fill(firstIndex, -1);
        Arrays.fill(lastIndex,  -1);

        for (int c = 0; c < 26; c++) {
            if (!positions[c].isEmpty()) {
                firstIndex[c] = positions[c].get(0);
                lastIndex[c]  = positions[c].get(positions[c].size() - 1);
            }
        }

        int count = 0;

        for (int x = 0; x < 26; x++) {
            if (positions[x].size() < 2) {
                continue;
            }
            int left  = firstIndex[x];
            int right = lastIndex[x];
            if (left == right) {
                continue;
            }

            for (int y = 0; y < 26; y++) {


                List<Integer> listY = positions[y];
                if (listY.isEmpty()) {
                    continue;
                }

                int idx = Collections.binarySearch(listY, left);


                if (idx < 0) {
                    idx = -idx - 1;
                } else {

                    idx = idx + 1;
                }

                if (idx < listY.size()) {
                    int candidatePos = listY.get(idx);
                    if (candidatePos < right) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        UniqueLength3PalindromicSubsequences solver = new UniqueLength3PalindromicSubsequences();


        String s1 = "aabca";
        System.out.println(s1 + " -> " + solver.countPalindromicSubsequence(s1));

        String s2 = "adc";
        System.out.println(s2 + " -> " + solver.countPalindromicSubsequence(s2));

    }
}
