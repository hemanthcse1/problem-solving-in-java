package examples.interviewquestions.dynamicprogramming.easy;

public class DivisorGame {
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        DivisorGame game = new DivisorGame();
        System.out.println(game.divisorGame(2));
        System.out.println(game.divisorGame(3));
    }
}
