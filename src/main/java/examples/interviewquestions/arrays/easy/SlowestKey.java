package examples.interviewquestions.arrays.easy;

public class SlowestKey {
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int maxDuration = releaseTimes[0];
        char resultKey = keysPressed.charAt(0);

        for (int i = 1; i < n; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char currentKey = keysPressed.charAt(i);

            if (duration > maxDuration || (duration == maxDuration && currentKey > resultKey)) {
                maxDuration = duration;
                resultKey = currentKey;
            }
        }

        return resultKey;
    }

    public static void main(String[] args) {
        int[] releaseTimes = {9, 29, 49, 50};
        String keysPressed = "cbcd";
        char result = slowestKey(releaseTimes, keysPressed);
        System.out.println("The key of the keypress that had the longest duration is: " + result);
    }
}
