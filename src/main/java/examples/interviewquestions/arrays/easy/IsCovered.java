package examples.interviewquestions.arrays.easy;

public class IsCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] covered = new boolean[51];

        for (int[] range : ranges) {
            int start = range[0];
            int end = range[1];
            for (int i = start; i <= end; i++) {
                covered[i] = true;
            }
        }

        for (int i = left; i <= right; i++) {
            if (!covered[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsCovered solution = new IsCovered();

        int[][] ranges1 = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(solution.isCovered(ranges1, 2, 5));

        int[][] ranges2 = {{1, 10}, {10, 20}};
        System.out.println(solution.isCovered(ranges2, 21, 21));
    }
}
