package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> gapCount = new HashMap<>();
        int maxGaps = 0;

        for (List<Integer> row : wall) {
            int position = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                position += row.get(i);
                gapCount.put(position, gapCount.getOrDefault(position, 0) + 1);
                maxGaps = Math.max(maxGaps, gapCount.get(position));
            }
        }

        return wall.size() - maxGaps;
    }

    public static void main(String[] args) {
        BrickWall brickwall = new BrickWall();

        List<List<Integer>> wall1 = List.of(
                List.of(1, 2, 2, 1),
                List.of(3, 1, 2),
                List.of(1, 3, 2),
                List.of(2, 4),
                List.of(3, 1, 2),
                List.of(1, 3, 1, 1)
        );
        System.out.println(brickwall.leastBricks(wall1));

        List<List<Integer>> wall2 = List.of(
                List.of(1),
                List.of(1),
                List.of(1)
        );
        System.out.println(brickwall.leastBricks(wall2));
    }
}
