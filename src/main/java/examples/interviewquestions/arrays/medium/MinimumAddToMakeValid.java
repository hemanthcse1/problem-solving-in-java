package examples.interviewquestions.arrays.medium;

public class MinimumAddToMakeValid {

    public int minAddToMakeValid(String s) {
        int balance = 0, result = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--;
                } else {
                    result++;
                }
            }
        }

        return result + balance;
    }

    public static void main(String[] args) {
        MinimumAddToMakeValid solution = new MinimumAddToMakeValid();
        String s1 = "())";
        System.out.println(solution.minAddToMakeValid(s1));

        String s2 = "(((";
        System.out.println(solution.minAddToMakeValid(s2));
    }
}
