package examples.interviewquestions.strings.easy;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
    public static boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();

        int x = 0, y = 0;
        visited.add(x + "," + y);

        for (char direction : path.toCharArray()) {

            if (direction == 'N') {
                y++;
            } else if (direction == 'S') {
                y--;
            } else if (direction == 'E') {
                x++;
            } else if (direction == 'W') {
                x--;
            }

            String currentPosition = x + "," + y;

            if (visited.contains(currentPosition)) {
                return true;
            }

            visited.add(currentPosition);
        }

        return false;
    }

    public static void main(String[] args) {
        String path = "NESWW";
        System.out.println("Does the path cross itself? " + isPathCrossing(path));
    }
}
