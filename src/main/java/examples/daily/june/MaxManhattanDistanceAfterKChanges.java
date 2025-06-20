package examples.daily.june;

public class MaxManhattanDistanceAfterKChanges {

    public static void main(String[] args) {
        MaxManhattanDistanceAfterKChanges solution = new MaxManhattanDistanceAfterKChanges();

        System.out.println("Output 1: " + solution.maxDistance("NWSE", 1)); // 3
        System.out.println("Output 2: " + solution.maxDistance("NSWWEW", 3)); //  6
    }

    public int maxDistance(String s, int k) {
        int northEast = simulate(s, k, "NE");
        int northWest = simulate(s, k, "NW");
        int southEast = simulate(s, k, "SE");
        int southWest = simulate(s, k, "SW");

        return Math.max(Math.max(northEast, northWest), Math.max(southEast, southWest));
    }

    private int simulate(String s, int k, String preferredDirections) {
        int maxDistance = 0;
        int position = 0;
        int changesNeeded = 0;

        for (char dir : s.toCharArray()) {
            if (preferredDirections.indexOf(dir) >= 0) {
                position++;
            } else {
                position--;
                changesNeeded++;
            }

            int boostedPosition = position + 2 * Math.min(k, changesNeeded);
            maxDistance = Math.max(maxDistance, boostedPosition);
        }

        return maxDistance;
    }
}
