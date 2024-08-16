package examples.interviewquestions.arrays.easy;

public class LongestTask {
    public int hardestWorker(int n, int[][] logs) {
        int maxTime = 0;
        int employeeId = Integer.MAX_VALUE;
        int previousLeaveTime = 0;
        for (int i = 0; i < logs.length; i++) {
            int currentId = logs[i][0];
            int currentLeaveTime = logs[i][1];
            int taskDuration = currentLeaveTime - previousLeaveTime;
            if (taskDuration > maxTime) {
                maxTime = taskDuration;
                employeeId = currentId;
            } else if (taskDuration == maxTime && currentId < employeeId) {
                employeeId = currentId;
            }
            previousLeaveTime = currentLeaveTime;
        }
        return employeeId;
    }
    public static void main(String[] args) {
        LongestTask lt = new LongestTask();

        int[][] logs1 = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        System.out.println(lt.hardestWorker(4, logs1));  // Output: 1
    }
}
