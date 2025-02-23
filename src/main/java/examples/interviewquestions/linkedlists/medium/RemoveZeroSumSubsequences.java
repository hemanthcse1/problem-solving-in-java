package examples.interviewquestions.linkedlists.medium;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumSubsequences {

    static
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;


        Map<Integer, ListNode> prefixMap = new HashMap<>();
        int prefixSum = 0;


        ListNode current = dummy;
        while (current != null) {
            prefixSum += current.val;
            prefixMap.put(prefixSum, current);
            current = current.next;
        }


        prefixSum = 0;
        current = dummy;
        while (current != null) {
            prefixSum += current.val;

            current.next = prefixMap.get(prefixSum).next;
            current = current.next;
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

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveZeroSumSubsequences solution = new RemoveZeroSumSubsequences();

        int[] test1 = {1,2,-3,3,1};
        ListNode head1 = createLinkedList(test1);
        printList(solution.removeZeroSumSublists(head1)); //  [3,1] or [1,2,1]

        int[] test2 = {1,2,3,-3,4};
        ListNode head2 = createLinkedList(test2);
        printList(solution.removeZeroSumSublists(head2)); //  [1,2,4]

        int[] test3 = {1,2,3,-3,-2};
        ListNode head3 = createLinkedList(test3);
        printList(solution.removeZeroSumSublists(head3)); //  [1]
    }
}
