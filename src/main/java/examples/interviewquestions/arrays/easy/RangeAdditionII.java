package examples.interviewquestions.arrays.easy;

public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;

        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        return minRow * minCol;
    }

    public static void main(String[] args) {
        RangeAdditionII solution = new RangeAdditionII();

        int[][] ops1 = {{2, 2}, {3, 3}};
        System.out.println(solution.maxCount(3, 3, ops1));

        int[][] ops2 = {};
        System.out.println(solution.maxCount(3, 3, ops2));

        int[][] ops3 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(solution.maxCount(3, 3, ops3));
    }
}
