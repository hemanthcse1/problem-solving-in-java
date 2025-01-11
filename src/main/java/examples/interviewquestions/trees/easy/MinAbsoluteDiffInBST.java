package examples.interviewquestions.trees.easy;

public class MinAbsoluteDiffInBST {

    static class BSTNode {
        int val;
        BSTNode left;
        BSTNode right;
        BSTNode(int val) { this.val = val; }
    }

    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(BSTNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(BSTNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        inorder(node.right);
    }

    public static void main(String[] args) {
        BSTNode root1 = new BSTNode(4);
        root1.left = new BSTNode(2);
        root1.right = new BSTNode(6);
        root1.left.left = new BSTNode(1);
        root1.left.right = new BSTNode(3);

        MinAbsoluteDiffInBST solution = new MinAbsoluteDiffInBST();
        System.out.println(solution.getMinimumDifference(root1));

        BSTNode root2 = new BSTNode(1);
        root2.left = new BSTNode(0);
        root2.right = new BSTNode(48);
        root2.right.left = new BSTNode(12);
        root2.right.right = new BSTNode(49);
        System.out.println(solution.getMinimumDifference(root2));
    }
}
