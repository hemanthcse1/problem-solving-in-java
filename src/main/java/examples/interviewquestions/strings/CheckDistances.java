package examples.interviewquestions.strings;

public class CheckDistances {
    public static boolean checkDistances(String s, int[] distance) {
        int[] firstOccurrence = new int[26];
        for (int i = 0; i < 26; i++) {
            firstOccurrence[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';

            if (firstOccurrence[index] == -1) {
                firstOccurrence[index] = i;
            } else {
                int expectedDistance = distance[index];
                int actualDistance = i - firstOccurrence[index] - 1;
                if (actualDistance != expectedDistance) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abaccb";
        int[] distance = {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean result = checkDistances(s, distance);
        System.out.println(result);
    }
}
