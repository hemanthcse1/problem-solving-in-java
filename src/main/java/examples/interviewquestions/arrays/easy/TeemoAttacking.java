package examples.interviewquestions.arrays.easy;

public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }

        int totalDuration = 0;

        for (int i = 1; i < timeSeries.length; i++) {
            int timeDifference = timeSeries[i] - timeSeries[i - 1];
            if (timeDifference < duration) {
                totalDuration += timeDifference;
            } else {
                totalDuration += duration;
            }
        }
        totalDuration += duration;

        return totalDuration;
    }

    public static void main(String[] args) {
        TeemoAttacking solution = new TeemoAttacking();

        int[] timeSeries1 = {1, 4};
        int duration1 = 2;
        System.out.println(solution.findPoisonedDuration(timeSeries1, duration1));

        int[] timeSeries2 = {1, 2};
        int duration2 = 2;
        System.out.println(solution.findPoisonedDuration(timeSeries2, duration2));
    }
}
