package examples.interviewquestions.linkedlists;

import java.util.Random;

public class RandomNodeFromLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private ListNode head;
    private Random random;

    public RandomNodeFromLinkedList(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int result = -1;
        ListNode current = head;
        int index = 0;

        while (current != null) {

            if (random.nextInt(index + 1) == 0) {
                result = current.val;
            }
            index++;
            current = current.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        RandomNodeFromLinkedList solution = new RandomNodeFromLinkedList(head);

        System.out.println(solution.getRandom()); // Should return 1, 2, or 3 randomly.
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }
}
