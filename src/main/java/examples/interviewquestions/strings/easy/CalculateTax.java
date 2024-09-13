package examples.interviewquestions.strings.easy;

public class CalculateTax {
    public double calculateTax(int[][] brackets, int income) {
        double totalTax = 0.0;
        int previousUpper = 0;

        for (int[] bracket : brackets) {
            int upper = bracket[0];
            int percent = bracket[1];

            int taxableIncome = Math.min(income, upper) - previousUpper;

            if (taxableIncome > 0) {
                totalTax += taxableIncome * percent / 100.0;
            }

            previousUpper = upper;

            if (income <= upper) {
                break;
            }
        }

        return totalTax;
    }

    public static void main(String[] args) {
        CalculateTax solution = new CalculateTax();

        int[][] brackets1 = {{3, 50}, {7, 10}, {12, 25}};
        int income1 = 10;
        System.out.println(solution.calculateTax(brackets1, income1));

        int[][] brackets2 = {{1, 0}, {4, 25}, {5, 50}};
        int income2 = 2;
        System.out.println(solution.calculateTax(brackets2, income2));

        int[][] brackets3 = {{2, 50}};
        int income3 = 0;
        System.out.println(solution.calculateTax(brackets3, income3));
    }
}
