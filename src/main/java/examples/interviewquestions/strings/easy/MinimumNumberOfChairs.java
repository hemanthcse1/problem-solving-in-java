package examples.interviewquestions.strings.easy;

public class MinimumNumberOfChairs {
    public static int minChairsRequired(String s) {
        int currentPeople = 0;
        int maxChairs = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                currentPeople++;
                maxChairs = Math.max(maxChairs, currentPeople);
            } else if (s.charAt(i) == 'L') {
                currentPeople--;
            }
        }
        return maxChairs;
    }

    public static void main(String[] args) {
        String s1 = "EEEEEEE";

        System.out.println(minChairsRequired(s1));
    }
}
