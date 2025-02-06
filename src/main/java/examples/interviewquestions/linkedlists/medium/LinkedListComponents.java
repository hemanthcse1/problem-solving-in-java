package examples.interviewquestions.linkedlists.medium;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int components = 0;
        ListNode curr = head;

        while (curr != null) {
            if (set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val))) {
                components++;
            }
            curr = curr.next;
        }

        return components;
    }

    public static void main(String[] args) {
        LinkedListComponents solution = new LinkedListComponents();


        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        int[] nums1 = {0, 1, 3};
        System.out.println(solution.numComponents(head1, nums1));

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(4);
        int[] nums2 = {0, 3, 1, 4};
        System.out.println(solution.numComponents(head2, nums2));
    }
}
