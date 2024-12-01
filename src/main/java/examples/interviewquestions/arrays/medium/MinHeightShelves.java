package examples.interviewquestions.arrays.medium;

public class MinHeightShelves {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int width = 0;
            int maxHeight = 0;
            dp[i] = Integer.MAX_VALUE;

            for (int j = i; j > 0; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth) break;
                maxHeight = Math.max(maxHeight, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        MinHeightShelves solution = new MinHeightShelves();

        int[][] books1 = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelfWidth1 = 4;
        System.out.println("Output 1: " + solution.minHeightShelves(books1, shelfWidth1));

        int[][] books2 = {{1, 3}, {2, 4}, {3, 2}};
        int shelfWidth2 = 6;
        System.out.println("Output 2: " + solution.minHeightShelves(books2, shelfWidth2));
    }
}
