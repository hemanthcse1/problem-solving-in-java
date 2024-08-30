package examples.interviewquestions.enumerations;

public class CommonFactors {
    public static int numberOfCommonFactors(int a, int b) {
        int count = 0;
        int min = Math.min(a, b);

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 18;

        int result = numberOfCommonFactors(a, b);
        System.out.println("Number of common factors: " + result);
    }
}
