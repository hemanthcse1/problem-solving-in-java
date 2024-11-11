package examples.interviewquestions.strings.medium;

public class MinimumPenaltyForShop {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int totalCustomers = 0;

        for (char c : customers.toCharArray()) {
            if (c == 'Y') totalCustomers++;
        }

        int minPenalty = totalCustomers;
        int penalty = minPenalty;
        int bestHour = 0;

        for (int j = 1; j <= n; j++) {
            if (customers.charAt(j - 1) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j;
            }
        }

        return bestHour;
    }

    public static void main(String[] args) {
        MinimumPenaltyForShop solution = new MinimumPenaltyForShop();
        System.out.println(solution.bestClosingTime("YYNY"));
        System.out.println(solution.bestClosingTime("NNNNN"));
        System.out.println(solution.bestClosingTime("YYYY"));
    }
}
