package examples.daily.february;

public class PunishmentNumberFinder {

    public static int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String squareStr = String.valueOf(square);
            if (canPartition(squareStr, 0, i, 0)) {
                sum += square;
            }
        }
        return sum;
    }

    private static boolean canPartition(String str, int index, int target, int currentSum) {
        if (index == str.length()) {
            return currentSum == target;
        }

        int num = 0;
        for (int j = index; j < str.length(); j++) {
            num = num * 10 + (str.charAt(j) - '0');
            if (num + currentSum > target) {
                break;
            }
            if (canPartition(str, j + 1, target, currentSum + num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));
        System.out.println(punishmentNumber(37));
    }
}
