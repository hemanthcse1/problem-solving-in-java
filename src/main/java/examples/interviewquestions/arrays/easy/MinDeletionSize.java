package examples.interviewquestions.arrays.easy;

public class MinDeletionSize {
    public int minDeletionSize(String[] strs) {
        int numCols = strs[0].length();
        int numRows = strs.length;
        int deleteCount = 0;

        for (int col = 0; col < numCols; col++) {
            for (int row = 1; row < numRows; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    deleteCount++;
                    break;
                }
            }
        }

        return deleteCount;
    }

    public static void main(String[] args) {
        MinDeletionSize solution = new MinDeletionSize();

        String[] strs1 = {"cba", "daf", "ghi"};
        System.out.println(solution.minDeletionSize(strs1));


        String[] strs2 = {"a", "b"};
        System.out.println(solution.minDeletionSize(strs2));

        String[] strs3 = {"zyx", "wvu", "tsr"};
        System.out.println(solution.minDeletionSize(strs3));
    }
}
