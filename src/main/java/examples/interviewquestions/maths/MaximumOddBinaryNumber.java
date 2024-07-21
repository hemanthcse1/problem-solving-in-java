package examples.interviewquestions.maths;

public class MaximumOddBinaryNumber {

    public static void main(String[] args) {
        String binary = "1010";

        System.out.println("Result -> "+maxOddBinaryNumber(binary));
    }

    public static String maxOddBinaryNumber(String binary) {
        int countOnes = 0;
        int countZeros = 0;

        for (char c : binary.toCharArray()) {
            if (c == '1') {
                countOnes++;
            } else {
                countZeros++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < countOnes - 1; i++) {
            result.append("1");
        }

        for (int i = 0; i < countZeros; i++) {
            result.append("0");
        }

        result.append("1");
        return result.toString();
    }
}
