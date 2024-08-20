package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class FindPeaks {
    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                peaks.add(i);
            }
        }

        return peaks;
    }

    public static void main(String[] args) {
        int[] mountain = {2, 4, 3, 5, 1, 7, 3, 8, 6, 4};
        List<Integer> result = findPeaks(mountain);

        System.out.println(result);
    }
}
