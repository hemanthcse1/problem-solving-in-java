package examples.interviewquestions.matrixes.easy;

public class Convert1DTo2DArray {
    public static void main(String[] args) {
        int[] original1 = {1, 2, 3, 4};
        int m1 = 2;
        int n1 = 2;
        int[][] result1 = construct2DArray(original1, m1, n1);
        print2DArray(result1);

        int[] original2 = {1, 2, 3};
        int m2 = 1;
        int n2 = 3;
        int[][] result2 = construct2DArray(original2, m2, n2);
        print2DArray(result2);

        int[] original3 = {1, 2};
        int m3 = 1;
        int n3 = 1;
        int[][] result3 = construct2DArray(original3, m3, n3);
        print2DArray(result3);
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }
        int[][] result = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }
        return result;
    }

    public static void print2DArray(int[][] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
