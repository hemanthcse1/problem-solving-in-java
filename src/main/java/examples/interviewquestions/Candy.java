package examples.interviewquestions;

public class Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] ratings1 = {1, 0, 2};
        System.out.println(candy(ratings1));

        int[] ratings2 = {1, 2, 2};
        System.out.println(candy(ratings2));
    }
}
