package examples.interviewquestions.linkedlists.medium;

public class RemoveNodes {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode removeNodes(ListNode head) {
        head = reverse(head);

        ListNode curr = head;
        ListNode maxNode = head;
        ListNode prev = head;

        while (curr != null) {
            if (curr.val < maxNode.val) {
                prev.next = curr.next;
            } else {
                maxNode = curr;
                prev = curr;
            }
            curr = curr.next;
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveNodes solution = new RemoveNodes();


        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(13);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(8);
        printList(solution.removeNodes(head1));


        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(1);
        printList(solution.removeNodes(head2));
    }

}
