package examples.daily.march;

public class CarRepairTime {
    public static long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long) 1e14, result = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isPossible(ranks, cars, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] ranks, int cars, long time) {
        long repaired = 0;
        for (int rank : ranks) {
            repaired += Math.sqrt(time / rank);
        }
        return repaired >= cars;
    }

    public static void main(String[] args) {
        int[] ranks1 = {4, 2, 3, 1};
        int cars1 = 10;
        System.out.println(repairCars(ranks1, cars1));

        int[] ranks2 = {5, 1, 8};
        int cars2 = 6;
        System.out.println(repairCars(ranks2, cars2));
    }
}
