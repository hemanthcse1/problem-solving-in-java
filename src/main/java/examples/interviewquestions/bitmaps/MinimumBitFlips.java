package examples.interviewquestions.bitmaps;

public class MinimumBitFlips {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;

        while (xor > 0) {
            count += xor & 1;
            xor >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        MinimumBitFlips solution = new MinimumBitFlips();

        System.out.println(solution.minBitFlips(10, 7));
        System.out.println(solution.minBitFlips(3, 4));
    }
}
