package examples.interviewquestions.strings.medium;

public class SolveTheEquation {
    public String solveEquation(String equation) {
        String[] sides = equation.split("=");

        int[] left = parseSide(sides[0]);
        int[] right = parseSide(sides[1]);

        int xCoeff = left[0] - right[0];
        int constant = right[1] - left[1];

        if (xCoeff == 0 && constant == 0) return "Infinite solutions";
        if (xCoeff == 0) return "No solution";

        return "x=" + (constant / xCoeff);
    }

    private int[] parseSide(String side) {
        int xCoeff = 0;
        int constant = 0;
        int i = 0;
        int n = side.length();

        while (i < n) {
            int sign = 1;
            if (side.charAt(i) == '+' || side.charAt(i) == '-') {
                sign = (side.charAt(i) == '-') ? -1 : 1;
                i++;
            }

            int num = 0;
            boolean hasNum = false;
            while (i < n && Character.isDigit(side.charAt(i))) {
                num = num * 10 + (side.charAt(i) - '0');
                i++;
                hasNum = true;
            }

            if (i < n && side.charAt(i) == 'x') {
                xCoeff += sign * (hasNum ? num : 1);
                i++;
            } else {
                constant += sign * num;
            }
        }

        return new int[]{xCoeff, constant};
    }

    public static void main(String[] args) {
        SolveTheEquation equation = new SolveTheEquation();

        System.out.println(equation.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(equation.solveEquation("x=x"));
        System.out.println(equation.solveEquation("2x=x"));
    }
}
