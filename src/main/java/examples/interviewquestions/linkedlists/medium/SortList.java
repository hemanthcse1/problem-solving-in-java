package examples.interviewquestions.linkedlists.medium;

public class SortList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode rightHalf = mid.next;
        mid.next = null;

        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(rightHalf);

        return merge(leftSorted, rightSorted);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);

        SortList solution = new SortList();
        ListNode sorted1 = solution.sortList(head1);
        printList(sorted1);

        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);

        ListNode sorted2 = solution.sortList(head2);
        printList(sorted2);


        ListNode head3 = null;
        ListNode sorted3 = solution.sortList(head3);
        printList(sorted3);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
