package examples.interviewquestions.strings.easy;

public class NumberOfChangingKeys {
    public static int countKeyChanges(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int keyChanges = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(i - 1))) {
                keyChanges++;
            }
        }
        return keyChanges;
    }

    public static void main(String[] args) {
        String s1 = "aAbBcC";

        System.out.println(countKeyChanges(s1));
    }

}
