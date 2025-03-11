package examples.daily.march;

public class NumberOfSubstringsContainingABC {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] freq = new int[3];
        int left = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {
            freq[index(s.charAt(right))]++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += (n - right);


                freq[index(s.charAt(left))]--;
                left++;
            }
        }

        return count;
    }

    private int index(char c) {
        if (c == 'a') return 0;
        if (c == 'b') return 1;
        return 2;
    }

    public static void main(String[] args) {
        NumberOfSubstringsContainingABC solver = new NumberOfSubstringsContainingABC();
        System.out.println(solver.numberOfSubstrings("abcabc")); // 10
        System.out.println(solver.numberOfSubstrings("aaacb"));  // 3
        System.out.println(solver.numberOfSubstrings("abc"));    // 1
    }
}
