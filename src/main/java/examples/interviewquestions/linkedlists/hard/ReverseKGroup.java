package examples.interviewquestions.linkedlists.hard;

public class ReverseKGroup {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0), prevTail = dummy;
        dummy.next = head;
        while (true) {
            ListNode kth = getKthNode(prevTail, k);
            if (kth == null) break;
            ListNode nextSeg = kth.next, segHead = prevTail.next, prev = null, curr = segHead;
            for (int i = 0; i < k; i++) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            prevTail.next = prev;
            segHead.next = nextSeg;
            prevTail = segHead;
        }
        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        ListNode curr = start;
        for (int i = 0; i < k; i++) {
            curr = curr.next;
            if (curr == null) return null;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        ReverseKGroup sol = new ReverseKGroup();
        ListNode newHead = sol.reverseKGroup(head, 2);
        printList(newHead);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
            if (curr != null) System.out.print("->");
        }
        System.out.println();
    }

}
