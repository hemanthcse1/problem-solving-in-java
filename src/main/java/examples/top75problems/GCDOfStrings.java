package examples.top75problems;

public class GCDOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        GCDOfStrings solution = new GCDOfStrings();
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(solution.gcdOfStrings(str1, str2));
    }
}
