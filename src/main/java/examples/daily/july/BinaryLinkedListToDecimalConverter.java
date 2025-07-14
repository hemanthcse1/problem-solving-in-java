package examples.daily.july;

public class BinaryLinkedListToDecimalConverter {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class Solution {
        public int getDecimalValue(ListNode head) {
            int result = 0;
            while (head != null) {
                result = (result << 1) | head.val;
                head = head.next;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 0 -> 1 (binary: 101)
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));

        Solution solution = new Solution();
        int decimalValue = solution.getDecimalValue(head);

        System.out.println("Decimal value of binary linked list: " + decimalValue); //  5
    }
}
