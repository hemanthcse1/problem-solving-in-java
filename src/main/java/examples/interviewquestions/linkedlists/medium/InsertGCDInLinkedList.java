package examples.interviewquestions.linkedlists.medium;

public class InsertGCDInLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            int gcdValue = gcd(current.val, current.next.val);
            ListNode gcdNode = new ListNode(gcdValue);
            gcdNode.next = current.next;
            current.next = gcdNode;
            current = gcdNode.next;
        }

        return head;
    }


    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        InsertGCDInLinkedList solution = new InsertGCDInLinkedList();

        int[] test1 = {18, 6, 10, 3};
        ListNode head1 = createLinkedList(test1);
        printList(solution.insertGreatestCommonDivisors(head1)); //  18 -> 6 -> 6 -> 2 -> 10 -> 1 -> 3 -> null

        int[] test2 = {7};
        ListNode head2 = createLinkedList(test2);
        printList(solution.insertGreatestCommonDivisors(head2)); //  7 -> null
    }
}
