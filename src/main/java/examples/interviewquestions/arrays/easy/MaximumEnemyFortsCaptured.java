package examples.interviewquestions.arrays.easy;

public class MaximumEnemyFortsCaptured {
    public static int captureForts(int[] forts) {
        int n = forts.length;
        int maxCaptured = 0;

        for (int i = 0; i < n; i++) {
            if (forts[i] == 1) {
                int rightCaptured = 0;
                for (int j = i + 1; j < n; j++) {
                    if (forts[j] == -1) {
                        maxCaptured = Math.max(maxCaptured, rightCaptured);
                        break;
                    } else if (forts[j] == 1) {
                        break;
                    } else if (forts[j] == 0) {
                        rightCaptured++;
                    }
                }

                int leftCaptured = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (forts[j] == -1) {
                        maxCaptured = Math.max(maxCaptured, leftCaptured);
                        break;
                    } else if (forts[j] == 1) {
                        break;
                    } else if (forts[j] == 0) {
                        leftCaptured++;
                    }
                }
            }
        }

        return maxCaptured;
    }

    public static void main(String[] args) {
        int[] forts1 = {1, 0, 0, -1, 0, 0, 0, 0, 1};
        System.out.println(captureForts(forts1));

        int[] forts2 = {0, 0, 1, -1};
        System.out.println(captureForts(forts2));

        int[] forts3 = {1, 0, -1, 0, 1};
        System.out.println(captureForts(forts3));
    }
}
