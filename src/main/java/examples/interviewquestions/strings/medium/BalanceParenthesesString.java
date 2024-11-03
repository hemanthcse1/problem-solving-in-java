package examples.interviewquestions.strings.medium;

public class BalanceParenthesesString {
    public int minInsertions(String s) {
        int insertions = 0;
        int openCount = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                openCount++;
                i++;
            } else { // s.charAt(i) == ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (openCount > 0) {
                        openCount--;
                    } else {
                        insertions++;
                    }
                    i += 2;
                } else {
                    if (openCount > 0) {
                        openCount--;
                        insertions++;
                    } else {
                        insertions += 2;
                    }
                    i++;
                }
            }
        }

        insertions += openCount * 2;
        return insertions;
    }

    public static void main(String[] args) {
        BalanceParenthesesString balanceParentheses = new BalanceParenthesesString();
        System.out.println(balanceParentheses.minInsertions("(()))"));
        System.out.println(balanceParentheses.minInsertions("())"));
        System.out.println(balanceParentheses.minInsertions("))())("));
    }
}
