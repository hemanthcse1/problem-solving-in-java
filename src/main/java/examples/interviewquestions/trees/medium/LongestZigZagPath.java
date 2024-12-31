package examples.interviewquestions.trees.medium;

public class LongestZigZagPath {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxZigZag;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{-1, -1};
        }
        int[] leftInfo = dfs(node.left);
        int[] rightInfo = dfs(node.right);


        int comingFromLeft = leftInfo[1] + 1;

        int comingFromRight = rightInfo[0] + 1;


        maxZigZag = Math.max(maxZigZag, Math.max(comingFromLeft, comingFromRight));

        return new int[]{comingFromLeft, comingFromRight};
    }

    // Example usage
    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(1);
        root1.right.left.left = new TreeNode(1);
        root1.right.left.right = new TreeNode(1);
        root1.right.right.right = new TreeNode(1);
        root1.right.left.left.left = new TreeNode(1);
        root1.right.left.left.right = new TreeNode(1);

        LongestZigZagPath solver1 = new LongestZigZagPath();
        System.out.println(solver1.longestZigZag(root1));


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        root2.left.right = new TreeNode(1);
        root2.left.right.left = new TreeNode(1);
        root2.left.right.right = new TreeNode(1);
        root2.left.right.left.left = new TreeNode(1);
        root2.left.right.left.right = new TreeNode(1);

        LongestZigZagPath solver2 = new LongestZigZagPath();
        System.out.println(solver2.longestZigZag(root2));


        TreeNode root3 = new TreeNode(1);
        LongestZigZagPath solver3 = new LongestZigZagPath();
        System.out.println(solver3.longestZigZag(root3));
    }
}
