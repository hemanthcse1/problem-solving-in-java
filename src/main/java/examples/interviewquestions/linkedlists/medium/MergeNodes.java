package examples.interviewquestions.linkedlists.medium;

public class MergeNodes {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode temp = head.next;
        int sum = 0;

        while (temp != null) {
            if (temp.val != 0) {
                sum += temp.val;
            } else {

                current.next = new ListNode(sum);
                current = current.next;
                sum = 0;
            }
            temp = temp.next;
        }

        return dummy.next;
    }


    public static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeNodes solution = new MergeNodes();

        int[] input1 = {0, 3, 1, 0, 4, 5, 2, 0};
        ListNode head1 = createLinkedList(input1);
        ListNode result1 = solution.mergeNodes(head1);
        System.out.print("Output 1: ");
        printLinkedList(result1);


        int[] input2 = {0, 1, 0, 3, 0, 2, 2, 0};
        ListNode head2 = createLinkedList(input2);
        ListNode result2 = solution.mergeNodes(head2);
        System.out.print("Output 2: ");
        printLinkedList(result2);
    }
}
