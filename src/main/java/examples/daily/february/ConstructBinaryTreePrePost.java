package examples.daily.february;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePrePost {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return construct(preorder, postorder, postIndexMap, 0, 0, preorder.length);
    }

    private TreeNode construct(int[] preorder, int[] postorder, Map<Integer, Integer> postIndexMap,
                               int preStart, int postStart, int size) {
        if (size == 0) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if (size == 1) return root;

        int leftRootVal = preorder[preStart + 1];
        int leftSubtreeSize = postIndexMap.get(leftRootVal) - postStart + 1;

        root.left = construct(preorder, postorder, postIndexMap, preStart + 1, postStart, leftSubtreeSize);
        root.right = construct(preorder, postorder, postIndexMap, preStart + leftSubtreeSize + 1,
                postStart + leftSubtreeSize, size - leftSubtreeSize - 1);

        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTreePrePost solution = new ConstructBinaryTreePrePost();

        int[] preorder1 = {1,2,4,5,3,6,7};
        int[] postorder1 = {4,5,2,6,7,3,1};
        TreeNode root1 = solution.constructFromPrePost(preorder1, postorder1);
        inorderTraversal(root1); // 4 2 5 1 6 3 7

        System.out.println();

        int[] preorder2 = {1};
        int[] postorder2 = {1};
        TreeNode root2 = solution.constructFromPrePost(preorder2, postorder2);
        inorderTraversal(root2); // 1
    }
}
