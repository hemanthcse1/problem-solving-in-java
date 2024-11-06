package examples.interviewquestions.strings.medium;

public class NumberOfStepsToReduceBinary {
    public int numSteps(String s) {
        int steps = 0;

        StringBuilder binary = new StringBuilder(s);

        while (binary.length() > 1) {
            if (binary.charAt(binary.length() - 1) == '0') {
                binary.deleteCharAt(binary.length() - 1);
            } else {
                int i = binary.length() - 1;
                while (i >= 0 && binary.charAt(i) == '1') {
                    binary.setCharAt(i, '0');
                    i--;
                }

                if (i < 0) {
                    binary.insert(0, '1');
                } else {
                    binary.setCharAt(i, '1');
                }
            }
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        NumberOfStepsToReduceBinary solution = new NumberOfStepsToReduceBinary();

        System.out.println(solution.numSteps("1101"));
        System.out.println(solution.numSteps("10"));
        System.out.println(solution.numSteps("1"));
    }
}
