package examples.daily.june;

public class DistributeCandies {
    public long distributeCandies(int n, int limit) {
        long count = 0;
        for (int i = 0; i <= Math.min(n, limit); i++) {
            int remaining = n - i;
            int minJ = Math.max(0, remaining - limit);
            int maxJ = Math.min(remaining, limit);
            if (minJ <= maxJ) {
                count += (long)(maxJ - minJ + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DistributeCandies dc = new DistributeCandies();
        System.out.println(dc.distributeCandies(5, 2)); // 3
        System.out.println(dc.distributeCandies(3, 3)); // 10
        System.out.println(dc.distributeCandies(257169, 765944)); // 33068333035
    }
}
