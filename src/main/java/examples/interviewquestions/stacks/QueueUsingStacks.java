package examples.interviewquestions.stacks;

public class QueueUsingStacks {

    private java.util.Stack<Integer> stack1;
    private java.util.Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1 = new java.util.Stack<>();
        stack2 = new java.util.Stack<>();
    }

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
