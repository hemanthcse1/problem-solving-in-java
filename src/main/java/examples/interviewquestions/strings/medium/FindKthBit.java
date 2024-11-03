package examples.interviewquestions.strings.medium;

public class FindKthBit {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int lengthOfSnMinus1 = (1 << (n - 1)) - 1;
        if (k <= lengthOfSnMinus1) {
            return findKthBit(n - 1, k);
        } else if (k == lengthOfSnMinus1 + 1) {
            return '1';
        } else {
            char mirroredBit = findKthBit(n - 1, (1 << n) - k);
            return mirroredBit == '0' ? '1' : '0';
        }
    }

    public static void main(String[] args) {
        FindKthBit kthBit = new FindKthBit();
        System.out.println(kthBit.findKthBit(3, 1));
        System.out.println(kthBit.findKthBit(4, 11));
    }
}
