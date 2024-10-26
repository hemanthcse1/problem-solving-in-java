package examples.interviewquestions.strings.medium;

import examples.interviewquestions.stacks.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMinDifference {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            minutesList.add(hours * 60 + minutes);
        }

        Collections.sort(minutesList);

        int minDifference = Integer.MAX_VALUE;

        for (int i = 1; i < minutesList.size(); i++) {
            minDifference = Math.min(minDifference, minutesList.get(i) - minutesList.get(i - 1));
        }

        int wrapAroundDifference = (24 * 60 - minutesList.get(minutesList.size() - 1)) + minutesList.get(0);
        minDifference = Math.min(minDifference, wrapAroundDifference);

        return minDifference;
    }

    public static void main(String[] args) {
        FindMinDifference solution = new FindMinDifference();

        List<String> timePoints1 = List.of("23:59", "00:00");
        System.out.println(solution.findMinDifference(timePoints1));

        List<String> timePoints2 = List.of("00:00", "23:59", "00:00");
        System.out.println(solution.findMinDifference(timePoints2));
    }
}
