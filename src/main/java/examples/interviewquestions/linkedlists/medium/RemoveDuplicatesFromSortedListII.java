package examples.interviewquestions.linkedlists.medium;

public class RemoveDuplicatesFromSortedListII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        ListNode prev = dummy;

        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                int duplicateVal = cur.val;

                while (cur != null && cur.val == duplicateVal) {
                    cur = cur.next;
                }

                prev.next = cur;
            } else {

                prev = prev.next;
                cur = cur.next;
            }
        }

        return dummy.next;
    }


    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int val : arr) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }


    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    // Testing
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();


        ListNode head1 = buildList(new int[]{1,2,3,3,4,4,5});
        ListNode result1 = solution.deleteDuplicates(head1);
        printList(result1);


        ListNode head2 = buildList(new int[]{1,1,1,2,3});
        ListNode result2 = solution.deleteDuplicates(head2);
        printList(result2);
    }
}
