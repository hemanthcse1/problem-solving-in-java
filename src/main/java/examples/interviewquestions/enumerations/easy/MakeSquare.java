package examples.interviewquestions.enumerations.easy;

public class MakeSquare {
    public static boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int blackCount = 0, whiteCount = 0;
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        if (grid[i + x][j + y] == 'B') {
                            blackCount++;
                        } else {
                            whiteCount++;
                        }
                    }
                }
                if (blackCount >= 3 || whiteCount >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'B', 'B', 'W'},
                {'B', 'W', 'B'},
                {'W', 'B', 'W'}
        };

        char[][] grid2 = {
                {'B', 'B', 'B'},
                {'W', 'W', 'W'},
                {'B', 'B', 'B'}
        };

        System.out.println(canMakeSquare(grid1));
        System.out.println(canMakeSquare(grid2));
    }
}
