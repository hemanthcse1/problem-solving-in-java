package examples.interviewquestions.trees.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeWithPreAndInOrderTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private Map<Integer, Integer> inorderIndexMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        preorderIndex = 0;
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inorderIndexMap.get(rootVal);
        root.left = helper(preorder, inStart, inIndex - 1);
        root.right = helper(preorder, inIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        ConstructTreeWithPreAndInOrderTree sol = new ConstructTreeWithPreAndInOrderTree();
        TreeNode root = sol.buildTree(preorder, inorder);
        printInorder(root);
        System.out.println();
    }

    private static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }
}
