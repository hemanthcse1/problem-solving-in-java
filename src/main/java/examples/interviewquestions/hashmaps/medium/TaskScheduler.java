package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    public int taskSchedule(char[] tasks, int n) {

        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char task : tasks) {
            taskCounts.put(task, taskCounts.getOrDefault(task, 0) + 1);
        }

        int maxFrequency = 0;
        int maxCount = 0;
        for (int count : taskCounts.values()) {
            if (count > maxFrequency) {
                maxFrequency = count;
                maxCount = 1;
            } else if (count == maxFrequency) {
                maxCount++;
            }
        }

        int partCount = maxFrequency - 1;
        int partLength = n + 1;
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxFrequency * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    public static void main(String[] args) {
        TaskScheduler tasksched = new TaskScheduler();

        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(tasksched.taskSchedule(tasks1, 2));

        char[] tasks2 = {'A', 'C', 'A', 'B', 'D', 'B'};
        System.out.println(tasksched.taskSchedule(tasks2, 1));

        char[] tasks3 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(tasksched.taskSchedule(tasks3, 3));
    }
}
