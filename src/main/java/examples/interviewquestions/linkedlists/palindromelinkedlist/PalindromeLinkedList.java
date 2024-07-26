package examples.interviewquestions.linkedlists.palindromelinkedlist;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalfHead = reverseList(slow);

        ListNode firstHalfPointer = head;
        ListNode secondHalfPointer = secondHalfHead;
        boolean isPalindrome = true;
        while (isPalindrome && secondHalfPointer != null) {
            if (firstHalfPointer.val != secondHalfPointer.val) {
                isPalindrome = false;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }
        reverseList(secondHalfHead);

        return isPalindrome;
    }

    private ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindromeLinkedList checker = new PalindromeLinkedList();
        boolean result = checker.isPalindrome(head);
        System.out.println("Is palindrome: " + result); // Output: true
    }
}
