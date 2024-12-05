package examples.interviewquestions.arrays.medium;

public class MinimumSwapsToBalance {

    public int minSwaps(String s) {
        int imbalance = 0;
        int maxImbalance = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                imbalance--;
            } else {
                imbalance++;
            }
            maxImbalance = Math.max(maxImbalance, imbalance);
        }

        return (maxImbalance + 1) / 2;
    }

    public static void main(String[] args) {
        MinimumSwapsToBalance solution = new MinimumSwapsToBalance();

        String s1 = "][][";
        System.out.println(solution.minSwaps(s1));

        String s2 = "]]][[[";
        System.out.println(solution.minSwaps(s2));

    }
}
