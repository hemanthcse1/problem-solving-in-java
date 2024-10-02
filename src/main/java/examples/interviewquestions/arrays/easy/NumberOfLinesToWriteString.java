package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class NumberOfLinesToWriteString {
    public static int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentWidth = 0;

        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];

            if (currentWidth + width > 100) {
                lines++;
                currentWidth = width;
            } else {
                currentWidth += width;
            }
        }

        return new int[] {lines, currentWidth};
    }

    public static void main(String[] args) {
        int[] widths1 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(numberOfLines(widths1, s1)));

        int[] widths2 = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s2 = "bbbcccdddaaa";
        System.out.println(Arrays.toString(numberOfLines(widths2, s2)));
    }
}
