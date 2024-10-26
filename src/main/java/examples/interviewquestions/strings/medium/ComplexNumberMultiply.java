package examples.interviewquestions.strings.medium;

public class ComplexNumberMultiply {
    public String complexNumberMultiply(String num1, String num2) {
        String[] parts1 = num1.split("\\+|i");
        int real1 = Integer.parseInt(parts1[0]);
        int imaginary1 = Integer.parseInt(parts1[1]);

        String[] parts2 = num2.split("\\+|i");
        int real2 = Integer.parseInt(parts2[0]);
        int imaginary2 = Integer.parseInt(parts2[1]);

        int realResult = real1 * real2 - imaginary1 * imaginary2;
        int imaginaryResult = real1 * imaginary2 + imaginary1 * real2;

        return realResult + "+" + imaginaryResult + "i";
    }

    public static void main(String[] args) {
        ComplexNumberMultiply solution = new ComplexNumberMultiply();


        System.out.println(solution.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(solution.complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
