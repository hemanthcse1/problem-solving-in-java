package examples.interviewquestions.trees.medium;

public class CountGoodNodes {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(5);
        System.out.println("Example 1 Output: " + goodNodes(root1));


        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(2);
        System.out.println("Example 2 Output: " + goodNodes(root2));


        TreeNode root3 = new TreeNode(1);
        System.out.println("Example 3 Output: " + goodNodes(root3));


        TreeNode root4 = new TreeNode(5);
        root4.left = new TreeNode(4);
        root4.right = new TreeNode(5);
        root4.left.left = new TreeNode(1);
        root4.right.right = new TreeNode(5);
        System.out.println("Additional Test Case (All Good) Output: " + goodNodes(root4));


        TreeNode root5 = new TreeNode(10);
        root5.left = new TreeNode(5);
        root5.right = new TreeNode(6);
        root5.left.left = new TreeNode(2);
        root5.left.right = new TreeNode(3);
        root5.right.left = new TreeNode(1);
        root5.right.right = new TreeNode(0);
        System.out.println("Additional Test Case (Only Root Good) Output: " + goodNodes(root5));
    }

    public static int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode node, int max) {
        if (node == null) return 0;
        int count = node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);
        count += dfs(node.left, max);
        count += dfs(node.right, max);
        return count;
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
