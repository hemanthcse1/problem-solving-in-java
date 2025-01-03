package examples.interviewquestions.linkedlists.medium;

public class RotateList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        tail.next = head;

        k = k % length;
        if (k == 0) {
            tail.next = null;
            return head;
        }

        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
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
        RotateList solution = new RotateList();

        int[] values1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(values1);
        System.out.print("Original List 1: ");
        printList(head1);
        ListNode result1 = solution.rotateRight(head1, 2);
        System.out.print("Rotated List 1: ");
        printList(result1);

        int[] values2 = {0, 1, 2};
        ListNode head2 = createList(values2);
        System.out.print("Original List 2: ");
        printList(head2);
        ListNode result2 = solution.rotateRight(head2, 4);
        System.out.print("Rotated List 2: ");
        printList(result2);

        int[] values3 = {1, 2};
        ListNode head3 = createList(values3);
        System.out.print("Original List 3: ");
        printList(head3);
        ListNode result3 = solution.rotateRight(head3, 1);
        System.out.print("Rotated List 3: ");
        printList(result3);
    }
}
