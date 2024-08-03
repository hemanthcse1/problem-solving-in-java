package examples.interviewquestions.strings;

public class EncryptString {
    public static void main(String[] args) {
        String s = "dart";
        int k = 3;
        String encryptedString = encrypt(s, k);
        System.out.println("Encrypted String: " + encryptedString);
    }

    public static String encrypt(String s, int k) {
        int n = s.length();
        k = k % n;
        String encrypted = s.substring(n - k) + s.substring(0, n - k);
        return encrypted;
    }
}
