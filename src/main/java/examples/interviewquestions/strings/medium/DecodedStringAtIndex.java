package examples.interviewquestions.strings.medium;

public class DecodedStringAtIndex {

    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                decodedLength *= c - '0';
            } else {
                decodedLength++;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= decodedLength;

            if (k == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }

            if (Character.isDigit(c)) {
                decodedLength /= c - '0';
            } else {
                decodedLength--;
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }

    public static void main(String[] args) {
        DecodedStringAtIndex solution = new DecodedStringAtIndex();

        System.out.println("Result for s = \"leet2code3\", k = 10: " + solution.decodeAtIndex("leet2code3", 10));
        System.out.println("Result for s = \"ha22\", k = 5: " + solution.decodeAtIndex("ha22", 5));
    }
}
