package examples.interviewquestions.strings.easy;

public class EncryptedString {
    public static String encryptString(String s, int k) {
        int n = s.length();
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int newIndex = (i + k) % n;
            encrypted.append(s.charAt(newIndex));
        }

        return encrypted.toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println("Encrypted string: " + encryptString(s, k));
    }
}
