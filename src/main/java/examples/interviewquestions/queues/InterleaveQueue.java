package examples.interviewquestions.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveQueue {
    public static void interleaveQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) {
            System.out.println("Input queue must have an even number of elements");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        int halfSize = queue.size() / 2;

        // Push the first half of the queue into the stack
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.poll());
        }

        // Enqueue back the stack elements
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Dequeue the first half of the queue and enqueue them back
        for (int i = 0; i < halfSize; i++) {
            queue.add(queue.poll());
        }

        // Again push the first half into the stack
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.poll());
        }

        // Interleave the elements of the stack and queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
            queue.add(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        interleaveQueue(queue);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

}
