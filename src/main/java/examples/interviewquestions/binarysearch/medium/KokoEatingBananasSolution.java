package examples.interviewquestions.binarysearch.medium;

public class KokoEatingBananasSolution {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }
            if (hours <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args){
        KokoEatingBananasSolution solution = new KokoEatingBananasSolution();


        int[] piles1 = {3,6,7,11};
        int h1 = 8;
        System.out.println("Minimum K for piles [3,6,7,11] and h = 8: " + solution.minEatingSpeed(piles1, h1));


        int[] piles2 = {30,11,23,4,20};
        int h2 = 5;
        System.out.println("Minimum K for piles [30,11,23,4,20] and h = 5: " + solution.minEatingSpeed(piles2, h2));

    }
}
