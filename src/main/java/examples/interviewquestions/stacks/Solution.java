package examples.interviewquestions.stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        Stack<Integer> sandwichStack = new Stack<>();

        for (int student : students) {
            studentQueue.offer(student);
        }
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }
        int unableToEatCount = 0;
        while (!studentQueue.isEmpty() && unableToEatCount != studentQueue.size()) {
            int student = studentQueue.poll();

            if (student == sandwichStack.peek()) {
                sandwichStack.pop();
                unableToEatCount = 0;
            } else {
                studentQueue.offer(student);
                unableToEatCount++;
            }
        }
        return unableToEatCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        System.out.println(solution.countStudents(students, sandwiches));
    }
}
