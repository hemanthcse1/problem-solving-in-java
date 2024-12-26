package examples.interviewquestions.trees.easy;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.left.right.left = new TreeNode(4);
        root2.left.right.right = new TreeNode(2);
        root2.right.left = new TreeNode(9);
        root2.right.right = new TreeNode(8);

        boolean result1 = leafSimilar(root1, root2);
        System.out.println("Example 1 Output: " + result1);


        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(3);
        root4.right = new TreeNode(2);

        boolean result2 = leafSimilar(root3, root4);
        System.out.println("Example 2 Output: " + result2);


        TreeNode root5 = new TreeNode(1);
        TreeNode root6 = new TreeNode(1);
        boolean result3 = leafSimilar(root5, root6);
        System.out.println("Additional Test Case (Single Node) Output: " + result3);


        TreeNode root7 = new TreeNode(1);
        root7.left = new TreeNode(2);
        root7.left.left = new TreeNode(4);
        root7.right = new TreeNode(3);

        TreeNode root8 = new TreeNode(1);
        root8.left = new TreeNode(2);
        root8.right = new TreeNode(3);
        root8.right.left = new TreeNode(4);

        boolean result4 = leafSimilar(root7, root8);
        System.out.println("Additional Test Case (Different Leaves) Output: " + result4);
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private static void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        } else {
            getLeaves(node.left, leaves);
            getLeaves(node.right, leaves);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
