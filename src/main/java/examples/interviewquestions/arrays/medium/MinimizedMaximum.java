package examples.interviewquestions.arrays.medium;

public class MinimizedMaximum {

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 100000, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDistribute(n, quantities, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canDistribute(int n, int[] quantities, int maxProducts) {
        int requiredStores = 0;

        for (int quantity : quantities) {
            requiredStores += (quantity + maxProducts - 1) / maxProducts;
            if (requiredStores > n) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MinimizedMaximum solution = new MinimizedMaximum();
        System.out.println(solution.minimizedMaximum(6, new int[]{11, 6}));
        System.out.println(solution.minimizedMaximum(7, new int[]{15, 10, 10}));
        System.out.println(solution.minimizedMaximum(1, new int[]{100000}));
    }
}
