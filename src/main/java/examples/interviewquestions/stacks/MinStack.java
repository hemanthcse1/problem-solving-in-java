package examples.interviewquestions.stacks;

public class MinStack {
    private java.util.Stack<Integer> stack;
    private java.util.Stack<Integer> minStack;

    public MinStack() {
        stack = new java.util.Stack<>();
        minStack = new java.util.Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public int pop() {
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
        return top;
    }

    public int getMin() {
        return minStack.peek();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
