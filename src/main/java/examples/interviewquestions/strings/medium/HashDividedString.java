package examples.interviewquestions.strings.medium;

public class HashDividedString {
    public String hashString(String s, int k) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i += k) {
            String substring = s.substring(i, i + k);
            int sum = 0;

            for (char c : substring.toCharArray()) {
                sum += c - 'a';
            }

            int hashedChar = sum % 26;
            result.append((char) (hashedChar + 'a'));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        HashDividedString hashDividedString = new HashDividedString();

        System.out.println(hashDividedString.hashString("abcd", 2));
        System.out.println(hashDividedString.hashString("mxz", 3));
    }
}
