package examples.daily.march;

public class MinRecolorsForKBlack {

    public int minimumRecolors(String blocks, int k) {
        int minOperations = Integer.MAX_VALUE;
        int whiteCount = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        minOperations = whiteCount;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            minOperations = Math.min(minOperations, whiteCount);
        }

        return minOperations;
    }

    public static void main(String[] args) {
        MinRecolorsForKBlack solution = new MinRecolorsForKBlack();

        String blocks1 = "WBBWWBBWBW";
        int k1 = 7;
        System.out.println(solution.minimumRecolors(blocks1, k1)); //  3

        String blocks2 = "WBWBBBW";
        int k2 = 2;
        System.out.println(solution.minimumRecolors(blocks2, k2)); //  0
    }
}
