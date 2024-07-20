package examples.interviewquestions.maths;

public class SmallestEvenMultiple {
    public int findSmallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        } else {
            return 2 * n;
        }
    }

    public static void main(String[] args) {
        SmallestEvenMultiple sem = new SmallestEvenMultiple();
        int n1 = 5;
        int result1 = sem.findSmallestEvenMultiple(n1);
        System.out.println("Smallest Even Multiple of " + n1 + ": " + result1);

        int n2 = 6;
        int result2 = sem.findSmallestEvenMultiple(n2);
        System.out.println("Smallest Even Multiple of " + n2 + ": " + result2);
    }
}
