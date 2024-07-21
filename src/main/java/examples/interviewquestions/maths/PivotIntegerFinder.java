package examples.interviewquestions.maths;

public class PivotIntegerFinder {
    public static void main(String[] args) {
        int x = 8;
        System.out.println("Pivot Integer -> "+pivotInteger(x));
    }

    public static int pivotInteger(int n) {
        int totalSum = n * (n + 1) / 2;

        for (int x = 1; x <= n; x++) {
            int sum1toX = x * (x + 1) / 2;
            int sumXtoN = totalSum - (x * (x - 1) / 2);

            if (sum1toX == sumXtoN){
                return x;
            }
        }
        return -1;
    }
}
