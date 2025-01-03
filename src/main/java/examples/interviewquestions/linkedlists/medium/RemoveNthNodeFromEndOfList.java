package examples.interviewquestions.linkedlists.medium;

public class RemoveNthNodeFromEndOfList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }

    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for(int val : values){
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(current != null){
            sb.append(current.val);
            if(current.next != null){
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();

        int[] values1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(values1);
        System.out.print("Original List 1: ");
        printList(head1);
        ListNode result1 = solution.removeNthFromEnd(head1, 2);
        System.out.print("Modified List 1: ");
        printList(result1);

        int[] values2 = {1};
        ListNode head2 = createList(values2);
        System.out.print("Original List 2: ");
        printList(head2);
        ListNode result2 = solution.removeNthFromEnd(head2, 1);
        System.out.print("Modified List 2: ");
        printList(result2);

    }
}
