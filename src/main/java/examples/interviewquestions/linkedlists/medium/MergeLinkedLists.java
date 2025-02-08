package examples.interviewquestions.linkedlists.medium;

public class MergeLinkedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; this.next = null; }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;

        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        ListNode afterB = prevA.next;
        for (int i = a; i <= b; i++) {
            afterB = afterB.next;
        }

        prevA.next = list2;

        ListNode lastNode = list2;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = afterB;

        return list1;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(10);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(13);
        list1.next.next.next = new ListNode(6);
        list1.next.next.next.next = new ListNode(9);
        list1.next.next.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);

        MergeLinkedLists solution = new MergeLinkedLists();
        ListNode result = solution.mergeInBetween(list1, 3, 4, list2);

        printList(result);
    }
}
