package examples.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValuesInEachRow {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(9);

        LargestValuesInEachRow solution = new LargestValuesInEachRow();
        List<Integer> largestValues1 = solution.findLargestValues(root1);
        System.out.println(largestValues1);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        List<Integer> largestValues2 = solution.findLargestValues(root2);
        System.out.println(largestValues2);
    }

    public List<Integer> findLargestValues(TreeNode root) {
        List<Integer> largestValuesPerRow = new ArrayList<>();
        if (root == null) return largestValuesPerRow;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodeQueue.poll();
                if (currentNode.val > maxValue) {
                    maxValue = currentNode.val;
                }
                if (currentNode.left != null) nodeQueue.offer(currentNode.left);
                if (currentNode.right != null) nodeQueue.offer(currentNode.right);
            }

            largestValuesPerRow.add(maxValue);
        }

        return largestValuesPerRow;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
