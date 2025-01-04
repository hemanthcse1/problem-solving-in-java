package examples.interviewquestions.linkedlists.medium;

public class PartitionList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);

        ListNode left = leftDummy;
        ListNode right = rightDummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        right.next = null;
        left.next = rightDummy.next;

        return leftDummy.next;
    }

    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
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

    public static void main(String[] args) {
        PartitionList solution = new PartitionList();


        int[] arr1 = {1, 4, 3, 2, 5, 2};
        int x1 = 3;
        ListNode head1 = buildList(arr1);
        ListNode res1 = solution.partition(head1, x1);
        printList(res1);

        int[] arr2 = {2, 1};
        int x2 = 2;
        ListNode head2 = buildList(arr2);
        ListNode res2 = solution.partition(head2, x2);
        printList(res2);
    }
}
