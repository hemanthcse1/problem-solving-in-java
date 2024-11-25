package examples.interviewquestions.arrays.medium;

public class CircularGameWinner {
    public int findTheWinner(int n, int k) {
        int winner = 0;
        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1;
    }

    public static void main(String[] args) {
        CircularGameWinner solution = new CircularGameWinner();
        System.out.println(solution.findTheWinner(5, 2));
        System.out.println(solution.findTheWinner(6, 5));
    }
}
