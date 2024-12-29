package examples.interviewquestions.trees.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTSearcher {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        BSTSearcher solver = new BSTSearcher();
        TreeNode found = solver.searchBST(root, 2);
        printSubtree(found);

        TreeNode notFound = solver.searchBST(root, 5);
        printSubtree(notFound);
    }

    private static void printSubtree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> values = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                values.add("null");
                continue;
            }
            values.add(String.valueOf(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (!values.isEmpty() && values.get(values.size() - 1).equals("null")) {
            values.remove(values.size() - 1);
        }
        System.out.println(values);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
