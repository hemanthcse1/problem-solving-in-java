package examples.interviewquestions.maths;

public class Maximum69Number {
    public static int maximum69Number (int num) {
        String numStr = Integer.toString(num);

        char[] numChars = numStr.toCharArray();

        for (int i = 0; i < numChars.length; i++) {
            if (numChars[i] == '6') {
                numChars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(numChars));
    }

    public static void main(String[] args) {
        int num = 9669;
        int result = maximum69Number(num);
        System.out.println("Maximum number after changing at most one digit: " + result);  // Output: 9969
    }
}
