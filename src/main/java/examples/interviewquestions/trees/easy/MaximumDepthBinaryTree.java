package examples.interviewquestions.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Maximum Depth (Example 1): " + findMaxDepth(root1));


        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println("Maximum Depth (Example 2): " + findMaxDepth(root2));


        TreeNode root3 = null;
        System.out.println("Maximum Depth (Empty Tree): " + findMaxDepth(root3));


        TreeNode root4 = new TreeNode(5);
        System.out.println("Maximum Depth (Single Node): " + findMaxDepth(root4));


        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.left.left = new TreeNode(3);
        root5.left.left.left = new TreeNode(4);
        System.out.println("Maximum Depth (Left Skewed): " + findMaxDepth(root5));


        TreeNode root6 = new TreeNode(1);
        root6.right = new TreeNode(2);
        root6.right.right = new TreeNode(3);
        root6.right.right.right = new TreeNode(4);
        System.out.println("Maximum Depth (Right Skewed): " + findMaxDepth(root6));
    }

    public static int findMaxDepth(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
        }

        return depth;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
