package examples.interviewquestions.stacks;

public class CustomStack {

    // 1381. Design a Stack With Increment Operation

    private int[] stack;
    private int[] increment;
    private int size;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.increment = new int[maxSize];
        this.size = 0;
    }

    public void push(int x) {
        if (size < maxSize) {
            stack[size++] = x;
        }
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        size--;
        int res = stack[size] + increment[size];
        if (size > 0) {
            increment[size - 1] += increment[size];
        }
        increment[size] = 0;
        return res;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, size);
        if (limit > 0) {
            increment[limit - 1] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack stk = new CustomStack(3);
        stk.push(1);
        stk.push(2);
        System.out.println(stk.pop());
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.increment(5, 100);
        stk.increment(2, 100);
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }

}
