package examples.interviewquestions.trees.easy;

public class InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    // --- Demo usage ---
    public static void main(String[] args) {

        TreeNode root1 = buildTree(new Integer[]{4,2,7,1,3,6,9}, 0);

        invertTree(root1);

        printTree(root1);
        System.out.println();


        TreeNode root2 = buildTree(new Integer[]{2,1,3}, 0);
        invertTree(root2);
        printTree(root2);
        System.out.println();


    }

    private static TreeNode buildTree(Integer[] arr, int index) {
        if (index < arr.length && arr[index] != null) {
            TreeNode node = new TreeNode(arr[index]);
            node.left = buildTree(arr, 2 * index + 1);
            node.right = buildTree(arr, 2 * index + 2);
            return node;
        }
        return null;
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
