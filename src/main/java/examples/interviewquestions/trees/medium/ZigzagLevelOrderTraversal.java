package examples.interviewquestions.trees.medium;

import java.util.*;

public class ZigzagLevelOrderTraversal {

    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int val) { this.val = val; }
    }

    public List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (!leftToRight) {
                Collections.reverse(currentLevel);
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(9);
        root.right = new BinaryTreeNode(20);
        root.right.left = new BinaryTreeNode(15);
        root.right.right = new BinaryTreeNode(7);

        ZigzagLevelOrderTraversal solver = new ZigzagLevelOrderTraversal();
        List<List<Integer>> zigzag = solver.zigzagLevelOrder(root);
        System.out.println(zigzag);
    }
}
