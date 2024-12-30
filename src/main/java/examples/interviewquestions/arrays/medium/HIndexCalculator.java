package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class HIndexCalculator {
    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations1));

        int[] citations2 = {1, 3, 1};
        System.out.println(hIndex(citations2));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int hCandidate = n - i;
            if (citations[i] >= hCandidate) {
                return hCandidate;
            }
        }
        return 0;
    }
}
