package examples.interviewquestions.linkedlists.medium;

public class SortedListToLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return convertToBST(head, null);
    }

    private TreeNode convertToBST(ListNode start, ListNode end) {
        if (start == end) return null;

        ListNode mid = findMiddle(start, end);
        TreeNode root = new TreeNode(mid.val);

        root.left = convertToBST(start, mid);
        root.right = convertToBST(mid.next, end);

        return root;
    }

    private ListNode findMiddle(ListNode start, ListNode end) {
        ListNode slow = start, fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        SortedListToLinkedList solution = new SortedListToLinkedList();


        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);


        TreeNode root = solution.sortedListToBST(head);


        System.out.println("In-order Traversal of BST:");
        inorderPrint(root);
    }
}
