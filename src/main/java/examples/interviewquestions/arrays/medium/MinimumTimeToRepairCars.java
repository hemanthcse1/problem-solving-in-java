package examples.interviewquestions.arrays.medium;

public class MinimumTimeToRepairCars {
    public static long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = 100L * (long)cars * (long)cars;
        while (left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int r : ranks) {
                long canFix = (long)Math.floor(Math.sqrt((double)mid / r));
                count += canFix;
                if (count >= cars) break;
            }
            if (count >= cars) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] ranks = {4,2,3,1};
        int cars = 10;
        System.out.println(repairCars(ranks, cars));
    }
}
