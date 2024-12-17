package examples.interviewquestions.strings.medium;

public class ShortestPalindromeTest {
    public static void main(String[] args) {


        String s1 = "aacecaaa";
        String result1 = shortestPalindrome(s1);
        System.out.println(result1);

        String s2 = "abcd";
        String result2 = shortestPalindrome(s2);
        System.out.println(result2);
    }
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String rev = new StringBuilder(s).reverse().toString();
        String l = s + "#" + rev;
        int[] p = new int[l.length()];
        for(int i =1; i<l.length(); i++) {
            int j = p[i-1];
            while(j >0 && l.charAt(i)!= l.charAt(j)) {
                j = p[j-1];
            }
            if(l.charAt(i)==l.charAt(j)) j++;
            p[i]=j;
        }
        return new StringBuilder(s.substring(p[l.length()-1])).reverse().toString() + s;
    }
}
