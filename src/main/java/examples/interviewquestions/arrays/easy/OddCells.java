package examples.interviewquestions.arrays.easy;

public class OddCells {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int[] index : indices) {
            rowCount[index[0]]++;
            colCount[index[1]]++;
        }

        int oddCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rowCount[i] + colCount[j]) % 2 == 1) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }

    public static void main(String[] args) {
        OddCells solution = new OddCells();

        int[][] indices1 = {{0, 1}, {1, 1}};
        System.out.println(solution.oddCells(2, 3, indices1));

        int[][] indices2 = {{1, 1}, {0, 0}};
        System.out.println(solution.oddCells(2, 2, indices2));
    }
}
