package examples.daily.april;

public class LowestCommonAncestorDeepestLeaves {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestorDeepestLeaves solution = new LowestCommonAncestorDeepestLeaves();
        TreeNode lca = solution.lcaDeepestLeaves(root);
        System.out.println("Lowest Common Ancestor of Deepest Leaves: " + lca.val);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root).node;
    }

    private Result helper(TreeNode root) {
        if (root == null) return new Result(null, 0);
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (left.depth > right.depth) return new Result(left.node, left.depth + 1);
        if (right.depth > left.depth) return new Result(right.node, right.depth + 1);
        return new Result(root, left.depth + 1);
    }

    private static class Result {
        TreeNode node;
        int depth;
        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
