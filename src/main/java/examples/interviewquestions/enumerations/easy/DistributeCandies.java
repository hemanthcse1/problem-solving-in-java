package examples.interviewquestions.enumerations.easy;

public class DistributeCandies {
    public static int distributeCandies(int n, int limit) {
        int count = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                for (int k = 0; k <= limit; k++) {
                    if (i + j + k == n) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int limit = 3;

        int result = distributeCandies(n, limit);
        System.out.println("Total number of ways: " + result);
    }
}
