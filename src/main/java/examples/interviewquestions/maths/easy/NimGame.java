package examples.interviewquestions.maths.easy;

public class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        NimGame solution = new NimGame();

        System.out.println("Can you win with 4 stones? " + solution.canWinNim(4));
        System.out.println("Can you win with 1 stone? " + solution.canWinNim(1));
        System.out.println("Can you win with 2 stones? " + solution.canWinNim(2));
        System.out.println("Can you win with 5 stones? " + solution.canWinNim(5));
    }
}
