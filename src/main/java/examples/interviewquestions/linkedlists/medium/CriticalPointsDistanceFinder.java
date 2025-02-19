package examples.interviewquestions.linkedlists.medium;

import java.util.Arrays;

public class CriticalPointsDistanceFinder {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public int[] findCriticalPointsDistances(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstCritical = -1, lastCritical = -1, prevCritical = -1;
        int minDistance = Integer.MAX_VALUE, maxDistance = -1;
        int index = 1;
        ListNode prev = head, curr = head.next, next = head.next.next;

        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                if (firstCritical == -1) {
                    firstCritical = index;
                } else {
                    minDistance = Math.min(minDistance, index - prevCritical);
                    maxDistance = index - firstCritical;
                }
                prevCritical = index;
                lastCritical = index;
            }

            // Move pointers
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }

        if (firstCritical == lastCritical) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
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

    public static void main(String[] args) {
        CriticalPointsDistanceFinder finder = new CriticalPointsDistanceFinder();

        int[] test1 = {5,3,1,2,5,1,2};
        ListNode head1 = createLinkedList(test1);
        System.out.println(Arrays.toString(finder.findCriticalPointsDistances(head1))); //  [1,3]

        int[] test2 = {1,3,2,2,3,2,2,2,7};
        ListNode head2 = createLinkedList(test2);
        System.out.println(Arrays.toString(finder.findCriticalPointsDistances(head2))); //  [3,3]

        int[] test3 = {3,1};
        ListNode head3 = createLinkedList(test3);
        System.out.println(Arrays.toString(finder.findCriticalPointsDistances(head3))); //  [-1,-1]
    }
}
