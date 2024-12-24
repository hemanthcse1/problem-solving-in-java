package examples.interviewquestions.linkedlists.medium;

public class MiddleNodeDeleter {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddleNode(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null){
            prev.next = slow.next;
        }
        return head;
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

    private static void printLinkedList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val);
            if(current.next != null) System.out.print("->");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        MiddleNodeDeleter deleter = new MiddleNodeDeleter();

        int[] vals1 = {1,3,4,7,1,2,6};
        ListNode head1 = buildLinkedList(vals1);
        ListNode result1 = deleter.deleteMiddleNode(head1);
        printLinkedList(result1);

        int[] vals2 = {1,2,3,4};
        ListNode head2 = buildLinkedList(vals2);
        ListNode result2 = deleter.deleteMiddleNode(head2);
        printLinkedList(result2);

    }
}
