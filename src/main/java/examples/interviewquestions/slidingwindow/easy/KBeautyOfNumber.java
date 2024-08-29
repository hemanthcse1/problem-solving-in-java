package examples.interviewquestions.slidingwindow.easy;

public class KBeautyOfNumber {
    public static int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int length = numStr.length();
        int kBeautyCount = 0;

        for (int i = 0; i <= length - k; i++) {
            String substring = numStr.substring(i, i + k);
            int divisor = Integer.parseInt(substring);
            if (divisor != 0 && num % divisor == 0) {
                kBeautyCount++;
            }
        }

        return kBeautyCount;
    }

    public static void main(String[] args) {
        int num = 240;
        int k = 2;
        int result = divisorSubstrings(num, k);
        System.out.println("The K-Beauty of the number is: " + result);
    }
}
