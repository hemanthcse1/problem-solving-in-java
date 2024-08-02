package examples.interviewquestions.strings;

public class CountAsterisks {
    public static int countAsterisks(String s) {
        int asteriskCount = 0;
        boolean insidePair = false;

        for (char ch : s.toCharArray()) {
            if (ch == '|') {
                insidePair = !insidePair;
            } else if (ch == '*' && !insidePair) {
                asteriskCount++;
            }
        }

        return asteriskCount;
    }

    public static void main(String[] args) {
        String s = "l|*e*et|c**o|*de|";
        System.out.println(countAsterisks(s));
    }
}
