package examples.daily.medium.january;

public class FirstCompletelyPaintedRowOrColumn {
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] pos = new int[m * n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                pos[val][0] = i;
                pos[val][1] = j;
            }
        }

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int r = pos[val][0];
            int c = pos[val][1];

            rowCount[r]++;
            if (rowCount[r] == n) {
                return i;
            }
            colCount[c]++;
            if (colCount[c] == m) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 2};
        int[][] mat1 = {
                {1, 4},
                {2, 3}
        };
        System.out.println(firstCompleteIndex(arr1, mat1));

        int[] arr2 = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] mat2 = {
                {3, 2, 5},
                {1, 4, 6},
                {8, 7, 9}
        };
        System.out.println(firstCompleteIndex(arr2, mat2));
    }
}
