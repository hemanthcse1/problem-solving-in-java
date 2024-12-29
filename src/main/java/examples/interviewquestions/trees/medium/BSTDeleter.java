package examples.interviewquestions.trees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTDeleter {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        BSTDeleter solver = new BSTDeleter();
        TreeNode result = solver.deleteNode(root, 3);
        printSubtree(result);

        TreeNode result2 = solver.deleteNode(result, 0);
        printSubtree(result2);

        TreeNode emptyRoot = null;
        TreeNode result3 = solver.deleteNode(emptyRoot, 0);
        printSubtree(result3);
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
