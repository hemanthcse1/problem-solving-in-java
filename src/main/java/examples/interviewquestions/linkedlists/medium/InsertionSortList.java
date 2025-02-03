package examples.interviewquestions.linkedlists.medium;

public class InsertionSortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            current.next = prev.next;
            prev.next = current;

            current = nextNode;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        InsertionSortList solution = new InsertionSortList();

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode sortedHead = solution.insertionSortList(head);

        System.out.println("Sorted Linked List:");
        printList(sortedHead);
    }
}
