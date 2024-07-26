package examples.interviewquestions.linkedlists.binarytointeger;

public class ConvertBinaryToInteger {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = (result << 1) | head.val;
            head = head.next;
        }
        return result;
    }
    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        ConvertBinaryToInteger converter = new ConvertBinaryToInteger();
        int decimalValue = converter.getDecimalValue(head);
        System.out.println("Decimal value: " + decimalValue);
    }
}
