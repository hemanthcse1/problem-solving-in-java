package examples.top75problems;

public class SignOfProduct {
    public int arraySign(int[] nums) {
        int negativeCount = 0;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negativeCount++;
            }
        }

        return (negativeCount % 2 == 0) ? 1 : -1;
    }

    public static void main(String[] args) {
        SignOfProduct solution = new SignOfProduct();
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        System.out.println(solution.arraySign(nums));

    }
}
