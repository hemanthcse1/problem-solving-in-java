package examples.daily.medium.january;

public class ParenthesesValidityChecker {

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;
        int minBalance = 0, maxBalance = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean isLocked = locked.charAt(i) == '1';
            if (isLocked) {
                if (s.charAt(i) == '(') {
                    minBalance++;
                    maxBalance++;
                } else {
                    minBalance--;
                    maxBalance--;
                }
            } else {
                minBalance--;
                maxBalance++;
            }
            if (maxBalance < 0) return false;
            if (minBalance < 0) minBalance = 0;
        }
        if (minBalance != 0) return false;

        minBalance = 0;
        maxBalance = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            boolean isLocked = locked.charAt(i) == '1';
            if (isLocked) {
                if (s.charAt(i) == ')') {
                    minBalance++;
                    maxBalance++;
                } else {
                    minBalance--;
                    maxBalance--;
                }
            } else {
                minBalance--;
                maxBalance++;
            }
            if (maxBalance < 0) return false;
            if (minBalance < 0) minBalance = 0;
        }
        return minBalance == 0;
    }

    public static void main(String[] args) {
        ParenthesesValidityChecker checker = new ParenthesesValidityChecker();
        String s1 = "))()))", locked1 = "010100";
        System.out.println(checker.canBeValid(s1, locked1));
        String s2 = "()()", locked2 = "0000";
        System.out.println(checker.canBeValid(s2, locked2));
        String s3 = ")", locked3 = "0";
        System.out.println(checker.canBeValid(s3, locked3));
    }
}
