package examples.interviewquestions.matrixes.medium;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board1 = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife(board1);
        printBoard(board1);


        int[][] board2 = {
                {1,1},
                {1,0}
        };
        gameOfLife(board2);
        printBoard(board2);

    }

    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);

                if (board[i][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {

                    board[i][j] = 3;
                }

                if (board[i][j] == 0 && liveNeighbors == 3) {

                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private static int countLiveNeighbors(int[][] board, int x, int y) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = x + i, c = y + j;
                if (r >= 0 && r < m && c >= 0 && c < n) {

                    count += (board[r][c] & 1);
                }
            }
        }
        return count;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            System.out.print("[");
            for (int c = 0; c < row.length; c++) {
                System.out.print(row[c] + (c == row.length - 1 ? "" : ","));
            }
            System.out.print("]\n");
        }
        System.out.println();
    }
}
