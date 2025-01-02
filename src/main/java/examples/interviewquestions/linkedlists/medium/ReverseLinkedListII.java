package examples.interviewquestions.linkedlists.medium;

public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            if (prev == null) return null;
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < right - left; i++) {
            if (then == null) return null;
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
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
        ReverseLinkedListII solution = new ReverseLinkedListII();

        int[] values1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(values1);
        System.out.print("Original List 1: ");
        printList(head1);
        ListNode result1 = solution.reverseBetween(head1, 2, 4);
        System.out.print("Reversed List 1: ");
        printList(result1);

        int[] values2 = {5};
        ListNode head2 = createList(values2);
        System.out.print("Original List 2: ");
        printList(head2);
        ListNode result2 = solution.reverseBetween(head2, 1, 1);
        System.out.print("Reversed List 2: ");
        printList(result2);

        int[] values3 = {1, 2, 3, 4, 5, 6, 7};
        ListNode head3 = createList(values3);
        System.out.print("Original List 3: ");
        printList(head3);
        ListNode result3 = solution.reverseBetween(head3, 3, 6);
        System.out.print("Reversed List 3: ");
        printList(result3);
    }
}
