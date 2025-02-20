package examples.interviewquestions.linkedlists.medium;

public class ReverseEvenLengthGroups {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        int groupSize = 2;

        while (current != null) {

            int count = 0;
            ListNode groupStart = current;
            while (current != null && count < groupSize) {
                count++;
                current = current.next;
            }


            if (count % 2 == 0) {
                prev.next = reverseList(groupStart, count);

                prev = groupStart;
            } else {
                prev = getKthNode(groupStart, count - 1);
            }

            groupSize++;
        }

        return head;
    }


    private ListNode reverseList(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;

        while (k-- > 0 && current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head.next = current;
        return prev;
    }


    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k-- > 0) {
            node = node.next;
        }
        return node;
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
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseEvenLengthGroups solution = new ReverseEvenLengthGroups();

        int[] test1 = {5,2,6,3,9,1,7,3,8,4};
        ListNode head1 = createLinkedList(test1);
        printList(solution.reverseEvenLengthGroups(head1)); //  [5,6,2,3,9,1,4,8,3,7]

        int[] test2 = {1,1,0,6};
        ListNode head2 = createLinkedList(test2);
        printList(solution.reverseEvenLengthGroups(head2)); //  [1,0,1,6]

        int[] test3 = {1,1,0,6,5};
        ListNode head3 = createLinkedList(test3);
        printList(solution.reverseEvenLengthGroups(head3)); //  [1,0,1,5,6]
    }

}
