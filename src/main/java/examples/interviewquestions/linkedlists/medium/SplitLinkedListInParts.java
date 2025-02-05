package examples.interviewquestions.linkedlists.medium;

public class SplitLinkedListInParts {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int length = 0;
        ListNode temp = head;


        while (temp != null) {
            length++;
            temp = temp.next;
        }


        int baseSize = length / k;
        int extraParts = length % k;


        ListNode current = head;
        for (int i = 0; i < k; i++) {
            if (current == null) {
                result[i] = null;
                continue;
            }

            result[i] = current;
            int partSize = baseSize + (extraParts > 0 ? 1 : 0);
            extraParts--;


            for (int j = 1; j < partSize; j++) {
                current = current.next;
            }


            ListNode nextPart = current.next;
            current.next = null;
            current = nextPart;
        }

        return result;
    }

    public static void main(String[] args) {
        SplitLinkedListInParts solution = new SplitLinkedListInParts();

        // Create linked list: [1,2,3,4,5,6,7,8,9,10]
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= 10; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }


        ListNode[] result = solution.splitListToParts(head, 3);

        for (ListNode part : result) {
            printList(part);
        }
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
