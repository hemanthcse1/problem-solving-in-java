package examples.interviewquestions.graphs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 1;
        int maxLevel = 1;
        long maxSum = Long.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        // Example 1: [1,7,0,7,-8,null,null]
        /*
               1
              / \
             7   0
            / \
           7  -8
        */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(0);
        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(-8);

        System.out.println(maxLevelSum(root1));

        // Example 2: [989,null,10250,98693,-89388,null,null,null,-32127]
        /*
               989
                 \
                 10250
                 /   \
             98693  -89388
                   /
                -32127
        */
        TreeNode root2 = new TreeNode(989);
        root2.right = new TreeNode(10250);
        root2.right.left = new TreeNode(98693);
        root2.right.right = new TreeNode(-89388);
        root2.right.right.left = new TreeNode(-32127);

        System.out.println(maxLevelSum(root2));
    }
}
