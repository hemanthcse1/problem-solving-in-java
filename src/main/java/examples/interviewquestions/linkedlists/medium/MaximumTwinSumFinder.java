package examples.interviewquestions.linkedlists.medium;

public class MaximumTwinSumFinder {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int findMaxTwinSum(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null, curr = slow;
        while(curr != null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        int maxSum = 0;
        ListNode first = head, second = prev;
        while(second != null){
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return maxSum;
    }

    private static ListNode buildLinkedList(int[] values){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for(int val : values){
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        MaximumTwinSumFinder finder = new MaximumTwinSumFinder();

        int[] vals1 = {5,4,2,1};
        ListNode head1 = buildLinkedList(vals1);
        System.out.println(finder.findMaxTwinSum(head1));

        int[] vals2 = {4,2,2,3};
        ListNode head2 = buildLinkedList(vals2);
        System.out.println(finder.findMaxTwinSum(head2));

    }
}
