package examples.interviewquestions.linkedlists.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;


        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int n = list.size();
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }

        return result;
    }


    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        NextGreaterNode solution = new NextGreaterNode();


        ListNode head1 = createLinkedList(new int[]{2, 1, 5});
        printArray(solution.nextLargerNodes(head1)); //  [5, 5, 0]


        ListNode head2 = createLinkedList(new int[]{2, 7, 4, 3, 5});
        printArray(solution.nextLargerNodes(head2)); //  [7, 0, 5, 5, 0]
    }
}
