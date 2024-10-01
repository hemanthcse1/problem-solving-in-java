package examples.interviewquestions.arrays.easy;

public class TicTacToeWinner {
    public static String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];

        char currentPlayer = 'X';

        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];

            board[row][col] = currentPlayer;

            if (checkWin(board, row, col, currentPlayer)) {
                return currentPlayer == 'X' ? "A" : "B";
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    private static boolean checkWin(char[][] board, int row, int col, char player) {
        if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
            return true;
        }

        if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
            return true;
        }

        if (row == col && board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (row + col == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] moves1 = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        System.out.println(tictactoe(moves1));

        int[][] moves2 = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(tictactoe(moves2));

        int[][] moves3 = {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
        System.out.println(tictactoe(moves3));
    }
}
