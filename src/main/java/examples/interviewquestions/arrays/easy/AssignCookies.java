package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;
        while (childIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[childIndex]) {
                childIndex++;
            }
            cookieIndex++;
        }
        return childIndex;
    }

    public static void main(String[] args) {
        AssignCookies solution = new AssignCookies();
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println(solution.findContentChildren(g1, s1));

        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println(solution.findContentChildren(g2, s2));

        int[] g3 = {10, 9, 8, 7};
        int[] s3 = {5, 6, 7, 8};
        System.out.println(solution.findContentChildren(g3, s3));
    }
}
