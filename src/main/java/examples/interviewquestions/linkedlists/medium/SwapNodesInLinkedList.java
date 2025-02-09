package examples.interviewquestions.linkedlists.medium;

public class SwapNodesInLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; this.next = null; }
    }


    public ListNode swapNodes(ListNode head, int k) {
        ListNode firstK = head, secondK = head, temp = head;


        for (int i = 1; i < k; i++) {
            firstK = firstK.next;
        }


        ListNode forward = firstK;
        while (forward.next != null) {
            forward = forward.next;
            secondK = secondK.next;
        }

        int tempVal = firstK.val;
        firstK.val = secondK.val;
        secondK.val = tempVal;

        return head;
    }

    public static void main(String[] args) {
        SwapNodesInLinkedList solution = new SwapNodesInLinkedList();

        int[] values1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        ListNode head1 = createList(values1);
        System.out.print("Original list: ");
        printList(head1);
        ListNode swapped1 = solution.swapNodes(head1, k1);
        System.out.print("Swapped list: ");
        printList(swapped1);


        int[] values2 = {7, 9, 6, 6, 7, 8, 3, 0, 9, 5};
        int k2 = 5;
        ListNode head2 = createList(values2);
        System.out.print("Original list: ");
        printList(head2);
        ListNode swapped2 = solution.swapNodes(head2, k2);
        System.out.print("Swapped list: ");
        printList(swapped2);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
}
