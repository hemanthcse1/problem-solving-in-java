package examples.interviewquestions.linkedlists.reverselinkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList reverser = new ReverseLinkedList();
        ListNode reversedHead = reverser.reverseList(head);

        ListNode current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
