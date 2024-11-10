package examples.interviewquestions.strings.medium;

public class MovePiecesToObtainString {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            if (i == n && j == n) return true;
            if (i == n || j == n) return false;
            if (start.charAt(i) != target.charAt(j)) return false;

            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;

            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        MovePiecesToObtainString solution = new MovePiecesToObtainString();

        System.out.println(solution.canChange("_L__R__R_", "L______RR"));
        System.out.println(solution.canChange("R_L_", "__LR"));
        System.out.println(solution.canChange("_R", "R_"));
    }
}
