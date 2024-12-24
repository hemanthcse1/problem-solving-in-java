package examples.interviewquestions.linkedlists.medium;

public class OddEvenLinkedListRearranger {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rearrangeOddEven(ListNode head) {
        if(head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
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
        OddEvenLinkedListRearranger rearranger = new OddEvenLinkedListRearranger();

        int[] vals1 = {1,2,3,4,5};
        ListNode head1 = buildLinkedList(vals1);
        ListNode result1 = rearranger.rearrangeOddEven(head1);
        printLinkedList(result1);

        int[] vals2 = {2,1,3,5,6,4,7};
        ListNode head2 = buildLinkedList(vals2);
        ListNode result2 = rearranger.rearrangeOddEven(head2);
        printLinkedList(result2);

    }
}
