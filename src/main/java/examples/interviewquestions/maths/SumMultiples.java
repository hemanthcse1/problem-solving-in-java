package examples.interviewquestions.maths;

public class SumMultiples {
    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumMultiples sm = new SumMultiples();

        int n1 = 7;
        int result1 = sm.sumOfMultiples(n1);
        System.out.println("Sum of multiples in range 1 to " + n1 + ": " + result1);

        int n2 = 10;
        int result2 = sm.sumOfMultiples(n2);
        System.out.println("Sum of multiples in range 1 to " + n2 + ": " + result2);

        int n3 = 9;
        int result3 = sm.sumOfMultiples(n3);
        System.out.println("Sum of multiples in range 1 to " + n3 + ": " + result3);
    }
}
