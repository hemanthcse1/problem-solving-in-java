package examples.daily.june;

import java.util.ArrayList;
import java.util.List;

public class KMirrorFinder {

    public long kMirror(int k, int n) {
        long ans = 0;
        List<Character> A = new ArrayList<>();
        A.add('0');

        for (int count = 0; count < n; ) {
            A = nextKMirror(A, k);
            long num = baseKToDecimal(A, k);
            if (isDecimalPalindrome(num)) {
                ans += num;
                count++;
            }
        }

        return ans;
    }

    private List<Character> nextKMirror(List<Character> A, int k) {
        int len = A.size();
        for (int i = len / 2; i < len; i++) {
            int nextNum = A.get(i) - '0' + 1;
            if (nextNum < k) {
                char ch = (char) (nextNum + '0');
                A.set(i, ch);
                A.set(len - 1 - i, ch);
                for (int j = len / 2; j < i; j++) {
                    A.set(j, '0');
                    A.set(len - 1 - j, '0');
                }
                return A;
            }
        }

        List<Character> newA = new ArrayList<>();
        newA.add('1');
        for (int i = 0; i < len - 1; i++) {
            newA.add('0');
        }
        newA.add('1');
        return newA;
    }

    private long baseKToDecimal(List<Character> A, int k) {
        long num = 0;
        for (char ch : A) {
            num = num * k + (ch - '0');
        }
        return num;
    }

    private boolean isDecimalPalindrome(long num) {
        String s = Long.toString(num);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        KMirrorFinder sol = new KMirrorFinder();
        int k = 2;
        int n = 5;
        System.out.println("Sum of first " + n + " " + k + "-mirror numbers: " + sol.kMirror(k, n));
    }
}
