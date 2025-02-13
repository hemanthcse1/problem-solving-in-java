package examples.interviewquestions.linkedlists.medium;

public class DeleteNodeInLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        DeleteNodeInLinkedList solution = new DeleteNodeInLinkedList();

        solution.deleteNode(head.next);

        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}
