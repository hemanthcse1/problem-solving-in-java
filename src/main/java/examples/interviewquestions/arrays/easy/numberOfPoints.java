package examples.interviewquestions.arrays.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class numberOfPoints {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> coveredPoints = new HashSet<>();
        for (List<Integer> car : nums) {
            int start = car.get(0);
            int end = car.get(1);

            for (int i = start; i <= end; i++) {
                coveredPoints.add(i);
            }
        }

        return coveredPoints.size();
    }

    public static void main(String[] args) {

        numberOfPoints sol = new numberOfPoints();
        List<List<Integer>> nums = List.of(
                List.of(3, 6),
                List.of(1, 5),
                List.of(4, 7)
        );
        System.out.println(sol.numberOfPoints(nums));
    }
}
