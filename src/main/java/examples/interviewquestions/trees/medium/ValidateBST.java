package examples.interviewquestions.trees.medium;

public class ValidateBST {

    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int val) { this.val = val; }
    }

    public boolean isValidBST(BinaryTreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(BinaryTreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(2);
        root1.left = new BinaryTreeNode(1);
        root1.right = new BinaryTreeNode(3);

        ValidateBST validator = new ValidateBST();
        System.out.println(validator.isValidBST(root1));

        BinaryTreeNode root2 = new BinaryTreeNode(5);
        root2.left = new BinaryTreeNode(1);
        root2.right = new BinaryTreeNode(4);
        root2.right.left = new BinaryTreeNode(3);
        root2.right.right = new BinaryTreeNode(6);

        System.out.println(validator.isValidBST(root2));
    }

}
