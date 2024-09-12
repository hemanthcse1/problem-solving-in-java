package examples.interviewquestions.arrays.easy;

public class CountTestedDevices {
    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int testedDevicesCount = 0;

        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                testedDevicesCount++;

                for (int j = i + 1; j < n; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }

        return testedDevicesCount;
    }

    public static void main(String[] args) {
        CountTestedDevices solution = new CountTestedDevices();

        int[] batteryPercentages1 = {1, 1, 2, 1, 3};
        System.out.println(solution.countTestedDevices(batteryPercentages1));


        int[] batteryPercentages2 = {0, 1, 2};
        System.out.println(solution.countTestedDevices(batteryPercentages2));
    }
}
