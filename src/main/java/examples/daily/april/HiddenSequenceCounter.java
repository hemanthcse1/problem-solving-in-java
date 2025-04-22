package examples.daily.april;

public class HiddenSequenceCounter {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfArrays(new int[]{1, -3, 4}, 1, 6));         //  2
        System.out.println(solution.numberOfArrays(new int[]{3, -4, 5, 1, -2}, -4, 5)); //  4
        System.out.println(solution.numberOfArrays(new int[]{4, -7, 2}, 3, 6));         //  0
    }

    static class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            long min = 0, max = 0, sum = 0;
            for (int diff : differences) {
                sum += diff;
                min = Math.min(min, sum);
                max = Math.max(max, sum);
            }
            long low = lower - min;
            long high = upper - max;
            return (int) Math.max(0, high - low + 1);
        }
    }
}
