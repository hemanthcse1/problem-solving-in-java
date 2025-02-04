package examples.interviewquestions.linkedlists.medium;

public class LinkedListCycleTwo {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }


        if (fast == null || fast.next == null) {
            return null;
        }


        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);


        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;


        LinkedListCycleTwo solution = new LinkedListCycleTwo();
        ListNode cycleNode = solution.detectCycle(head);

        if (cycleNode != null) {
            System.out.println("Tail connects to node index: " + getIndex(head, cycleNode));
        } else {
            System.out.println("No cycle detected");
        }
    }

    public static int getIndex(ListNode head, ListNode target) {
        ListNode current = head;
        int index = 0;
        while (current != null) {
            if (current == target) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
}
