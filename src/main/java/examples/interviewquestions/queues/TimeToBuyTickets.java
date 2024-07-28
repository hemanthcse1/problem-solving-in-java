package examples.interviewquestions.queues;

public class TimeToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int n = tickets.length;

        while (tickets[k] > 0) {
            for (int i = 0; i < n; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    time++;
                }
                if (tickets[k] == 0) {
                    return time;
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        TimeToBuyTickets solution = new TimeToBuyTickets();
        int[] tickets = {2, 3, 2};
        int k = 2;
        System.out.println(solution.timeRequiredToBuy(tickets, k));
    }
}
