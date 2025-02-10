package examples.interviewquestions.linkedlists.medium;

public class DoubleLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode doubleIt(ListNode head) {
        int carry = helper(head);
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    private int helper(ListNode node) {
        if (node == null) return 0;

        int carry = helper(node.next);
        int newVal = node.val * 2 + carry;
        node.val = newVal % 10;
        return newVal / 10;
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList solution = new DoubleLinkedList();


        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(9);
        printList(solution.doubleIt(head1));


        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        printList(solution.doubleIt(head2));
    }
}
