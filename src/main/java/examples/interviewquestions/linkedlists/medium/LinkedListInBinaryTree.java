package examples.interviewquestions.linkedlists.medium;

public class LinkedListInBinaryTree {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null) return false;

        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(TreeNode root, ListNode head) {
        if (head == null) return true;
        if (root == null || root.val != head.val) return false;

        return dfs(root.left, head.next) || dfs(root.right, head.next);
    }


    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(8);
        return root;
    }

    public static void main(String[] args) {
        LinkedListInBinaryTree solution = new LinkedListInBinaryTree();

        int[] linkedListArr = {4, 2, 8};
        ListNode head = createLinkedList(linkedListArr);
        TreeNode root = createBinaryTree();

        System.out.println("Output: " + solution.isSubPath(head, root)); //  true
    }
}
