package examples.interviewquestions.strings.medium;

public class MinimumSuffixFlips {
    public int minFlips(String target) {
        int flips = 0;
        char prev = '0';

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != prev) {
                flips++;
                prev = target.charAt(i);
            }
        }
        return flips;
    }

    public static void main(String[] args) {
        MinimumSuffixFlips min = new MinimumSuffixFlips();

        System.out.println(min.minFlips("10111"));
        System.out.println(min.minFlips("101"));
        System.out.println(min.minFlips("00000"));
    }
}
