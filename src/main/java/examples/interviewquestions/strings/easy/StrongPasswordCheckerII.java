package examples.interviewquestions.strings.easy;

public class StrongPasswordCheckerII {

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialCharacters = "!@#$%^&*()-+";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (specialCharacters.indexOf(c) != -1) {
                hasSpecial = true;
            }

            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
        }

        return hasLower && hasUpper && hasDigit && hasSpecial;
    }

    public static void main(String[] args) {
        StrongPasswordCheckerII checker = new StrongPasswordCheckerII();

        System.out.println(checker.strongPasswordCheckerII("IloveLeetcode!"));
    }
}
