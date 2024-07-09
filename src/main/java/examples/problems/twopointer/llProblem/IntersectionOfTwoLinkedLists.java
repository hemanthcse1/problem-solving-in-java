package examples.problems.twopointer.llProblem;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        // Example usage:
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next = new ListNode(1);
        headB.next.next = common;

        Solution solution = new Solution();
        ListNode intersection = solution.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }

}
