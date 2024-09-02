package examples.interviewquestions.strings.easy;

public class FurthestPointFromOrigin {

    public int furthestDistance(String moves) {
        int leftCount = 0;
        int rightCount = 0;
        int underscoreCount = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'L') {
                leftCount++;
            } else if (move == 'R') {
                rightCount++;
            } else if (move == '_') {
                underscoreCount++;
            }
        }

        return Math.abs(leftCount - rightCount) + underscoreCount;
    }

    public static void main(String[] args) {
        FurthestPointFromOrigin solution = new FurthestPointFromOrigin();

        System.out.println(solution.furthestDistance("L_RL_"));
        System.out.println(solution.furthestDistance("_R_L_"));
        System.out.println(solution.furthestDistance("RRRLLL"));
    }
}
