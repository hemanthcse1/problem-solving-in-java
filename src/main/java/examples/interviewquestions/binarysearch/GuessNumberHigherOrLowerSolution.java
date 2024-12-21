package examples.interviewquestions.binarysearch;

public class GuessNumberHigherOrLowerSolution {

    static class GuessGame {
        private int pick;

        public void setPick(int pick) {
            this.pick = pick;
        }
        public int guess(int num) {
            if (num > pick) return -1;
            else if (num < pick) return 1;
            else return 0;
        }
    }

    static class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 1, high = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int res = guess(mid);
                if (res == 0) return mid;
                else if (res < 0) high = mid - 1;
                else low = mid + 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 10;
        int pick1 = 6;
        solution.setPick(pick1);
        System.out.println("Test Case 1: Expected = 6, Output = " + solution.guessNumber(n1));

        int n2 = 1;
        int pick2 = 1;
        solution.setPick(pick2);
        System.out.println("Test Case 2: Expected = 1, Output = " + solution.guessNumber(n2));

    }
}
