package examples.daily.february;

import java.util.Stack;

public class RecoverTreeFromPreorder {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int depth = 0;

            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }


            int value = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }


            TreeNode node = new TreeNode(value);


            while (stack.size() > depth) {
                stack.pop();
            }


            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }


            stack.push(node);
        }

        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        RecoverTreeFromPreorder solution = new RecoverTreeFromPreorder();

        String traversal1 = "1-2--3--4-5--6--7";
        TreeNode root1 = solution.recoverFromPreorder(traversal1);
        printTree(root1); //  1 2 3 4 5 6 7

        System.out.println();

        String traversal2 = "1-2--3---4-5--6---7";
        TreeNode root2 = solution.recoverFromPreorder(traversal2);
        printTree(root2); //  1 2 3 4 5 6 7

        System.out.println();

        String traversal3 = "1-401--349---90--88";
        TreeNode root3 = solution.recoverFromPreorder(traversal3);
        printTree(root3); //  1 401 349 90 88
    }
}
