package examples.interviewquestions.linkedlists.medium;

import java.util.Deque;
import java.util.LinkedList;

public class FrontMiddleBackQueue {

    private Deque<Integer> left;
    private Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() <= right.size()) {
            left.addLast(val);
        } else {
            right.addFirst(left.pollLast());
            left.addLast(val);
        }
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        int val = left.pollFirst();
        balance();
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        int val = left.pollLast();
        balance();
        return val;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        int val = right.isEmpty() ? left.pollLast() : right.pollLast();
        balance();
        return val;
    }

    private void balance() {
        if (left.size() > right.size() + 1) {
            right.addFirst(left.pollLast());
        } else if (right.size() > left.size()) {
            left.addLast(right.pollFirst());
        }
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();

        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);
        q.pushMiddle(4);

        System.out.println(q.popFront());
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        System.out.println(q.popBack());
        System.out.println(q.popFront());
    }

}
