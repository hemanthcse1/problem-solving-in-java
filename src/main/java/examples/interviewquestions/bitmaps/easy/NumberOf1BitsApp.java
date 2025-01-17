package examples.interviewquestions.bitmaps.easy;

public class NumberOf1BitsApp {

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight(2147483645));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
