package examples.hashtables.easy;

public class FindJudge {
    public static int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) {
            return 1;
        }
        int[] trustCount = new int[n + 1];
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            trustCount[a]--;
            trustCount[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int[][] trust1 = {{1, 3}, {2, 3}};
        System.out.println("The town judge is: " + findJudge(n1, trust1));
    }
}
