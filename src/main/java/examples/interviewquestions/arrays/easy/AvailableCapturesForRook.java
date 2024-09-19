package examples.interviewquestions.arrays.easy;

public class AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {
        int rookRow = -1, rookCol = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                    break;
                }
            }
            if (rookRow != -1) break;
        }

        int captures = 0;

        for (int i = rookRow - 1; i >= 0; i--) {
            if (board[i][rookCol] == 'B') break;
            if (board[i][rookCol] == 'p') {
                captures++;
                break;
            }
        }

        for (int i = rookRow + 1; i < 8; i++) {
            if (board[i][rookCol] == 'B') break;
            if (board[i][rookCol] == 'p') {
                captures++;
                break;
            }
        }

        for (int j = rookCol - 1; j >= 0; j--) {
            if (board[rookRow][j] == 'B') break;
            if (board[rookRow][j] == 'p') {
                captures++;
                break;
            }
        }

        for (int j = rookCol + 1; j < 8; j++) {
            if (board[rookRow][j] == 'B') break;
            if (board[rookRow][j] == 'p') {
                captures++;
                break;
            }
        }

        return captures;
    }

    public static void main(String[] args) {
        AvailableCapturesForRook solution = new AvailableCapturesForRook();

        char[][] board1 = {
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        };
        System.out.println("Test case 1 output: " + solution.numRookCaptures(board1));

        char[][] board2 = {
                {'.','.','.','.','.','.','.','.'},
                {'.','p','p','p','p','p','.','.'},
                {'.','p','p','B','p','p','.','.'},
                {'.','p','B','R','B','p','.','.'},
                {'.','p','p','B','p','p','.','.'},
                {'.','p','p','p','p','p','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        };
        System.out.println("Test case 2 output: " + solution.numRookCaptures(board2));

        char[][] board3 = {
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'p','p','.','R','.','p','B','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','B','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        };
        System.out.println("Test case 3 output: " + solution.numRookCaptures(board3));
    }
}
