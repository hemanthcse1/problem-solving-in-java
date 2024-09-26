package examples.interviewquestions.arrays.easy;

public class NumEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];

        int result = 0;

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            int key = Math.min(a, b) * 10 + Math.max(a, b);

            result += count[key];

            count[key]++;
        }

        return result;
    }

    public static void main(String[] args) {
        NumEquivDominoPairs solution = new NumEquivDominoPairs();

        int[][] dominoes1 = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(solution.numEquivDominoPairs(dominoes1));

        int[][] dominoes2 = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
        System.out.println(solution.numEquivDominoPairs(dominoes2));
    }
}
