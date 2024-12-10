package examples.daily;

public class FindLongestSpecialSubstring {
    public int findLongestSpecialSubstring(String s) {
        int n = s.length();
        int maxLen = -1;

        for (char c = 'a'; c <= 'z'; c++) {
            for (int len = n; len >= 1; len--) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    sb.append(c);
                }
                String sub = sb.toString();
                int count = 0;
                for (int start = 0; start <= n - len; start++) {
                    if (s.startsWith(sub, start)) {
                        count++;
                        if (count >= 3) {
                            maxLen = Math.max(maxLen, len);
                            break;
                        }
                    }
                }
                if (count >= 3) {
                    break;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        FindLongestSpecialSubstring sol = new FindLongestSpecialSubstring();
        System.out.println(sol.findLongestSpecialSubstring("aaaa"));
        System.out.println(sol.findLongestSpecialSubstring("abcdef"));
        System.out.println(sol.findLongestSpecialSubstring("abcaba"));
    }
}
