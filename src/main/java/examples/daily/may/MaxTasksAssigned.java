package examples.daily.may;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxTasksAssigned {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0, right = Math.min(tasks.length, workers.length);

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int count) {
        Deque<Integer> deque = new LinkedList<>();
        int taskIdx = 0;
        int availablePills = pills;

        for (int i = workers.length - count; i < workers.length; i++) {
            while (taskIdx < count && tasks[taskIdx] <= workers[i] + strength) {
                deque.offerLast(tasks[taskIdx++]);
            }

            if (deque.isEmpty()) {
                return false;
            }

            if (workers[i] >= deque.peekFirst()) {
                deque.pollFirst();
            } else {
                if (availablePills == 0) {
                    return false;
                }
                deque.pollLast();
                availablePills--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MaxTasksAssigned solution = new MaxTasksAssigned();

        int[] tasks1 = {3, 2, 1};
        int[] workers1 = {0, 3, 3};
        System.out.println(solution.maxTaskAssign(tasks1, workers1, 1, 1)); //  3

        int[] tasks2 = {5, 4};
        int[] workers2 = {0, 0, 0};
        System.out.println(solution.maxTaskAssign(tasks2, workers2, 1, 5)); //  1

        int[] tasks3 = {10, 15, 30};
        int[] workers3 = {0, 10, 10, 10, 10};
        System.out.println(solution.maxTaskAssign(tasks3, workers3, 3, 10)); //  2
    }
}
