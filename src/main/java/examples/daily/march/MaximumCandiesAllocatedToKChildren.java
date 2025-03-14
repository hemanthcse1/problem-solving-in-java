package examples.daily.march;

public class MaximumCandiesAllocatedToKChildren {

    public static int maximumCandies(int[] candies, long k) {
        long total = 0;
        for (int c : candies) {
            total += c;
        }
        if (total < k) {
            return 0;
        }
        int maxCandy = 0;
        for (int c : candies) {
            if (c > maxCandy) {
                maxCandy = c;
            }
        }
        int left = 1;
        int right = maxCandy;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = 0;
            for (int c : candies) {
                count += c / mid;
            }
            if (count >= k) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] candies1 = {5, 8, 6};
        long k1 = 3;
        System.out.println(maximumCandies(candies1, k1));
        int[] candies2 = {2, 5};
        long k2 = 11;
        System.out.println(maximumCandies(candies2, k2));
    }
}
