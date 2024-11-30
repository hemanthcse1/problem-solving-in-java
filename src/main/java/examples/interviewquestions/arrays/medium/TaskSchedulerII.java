package examples.interviewquestions.arrays.medium;

import java.util.HashMap;

public class TaskSchedulerII {

    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> lastDay = new HashMap<>();
        long currentDay = 0;

        for (int task : tasks) {
            currentDay++;
            if (lastDay.containsKey(task)) {
                long nextAvailableDay = lastDay.get(task) + space + 1;
                if (currentDay < nextAvailableDay) {
                    currentDay = nextAvailableDay;
                }
            }
            lastDay.put(task, currentDay);
        }

        return currentDay;
    }

    public static void main(String[] args) {
        TaskSchedulerII solution = new TaskSchedulerII();

        int[] tasks1 = {1, 2, 1, 2, 3, 1};
        int space1 = 3;
        System.out.println(solution.taskSchedulerII(tasks1, space1));

        int[] tasks2 = {5, 8, 8, 5};
        int space2 = 2;
        System.out.println(solution.taskSchedulerII(tasks2, space2));
    }
}
