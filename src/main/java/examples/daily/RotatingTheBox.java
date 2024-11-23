package examples.daily;

import java.util.Arrays;

public class RotatingTheBox {

    public char[][] rotateTheBox(char[][] box) {

        int m = box.length;
        int n = box[0].length;

        for (int i = 0; i < m; i++) {
            int empty = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    empty = j - 1;
                } else if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    empty--;
                }
            }
        }

        char[][] rotated = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - i - 1] = box[i][j];
            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        RotatingTheBox solution = new RotatingTheBox();

        char[][] box1 = {{'#', '.', '#'}};
        System.out.println(Arrays.deepToString(solution.rotateTheBox(box1)));

        char[][] box2 = {
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        };
        System.out.println(Arrays.deepToString(solution.rotateTheBox(box2)));

        char[][] box3 = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };
        System.out.println(Arrays.deepToString(solution.rotateTheBox(box3)));
    }
}
