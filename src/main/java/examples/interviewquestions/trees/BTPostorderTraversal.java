package examples.interviewquestions.trees;

import java.util.ArrayList;
import java.util.List;

public class BTPostorderTraversal {

    public static void main(String[] args) {
        BinaryTreePostorderTraversal solver = new BinaryTreePostorderTraversal();

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        List<Integer> result1 = solver.postorderTraversal(root1);
        System.out.println("Output for Example 1: " + result1);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(8);
        root2.left.right.left = new TreeNode(6);
        root2.left.right.right = new TreeNode(7);
        root2.right.right.left = new TreeNode(9);
        List<Integer> result2 = solver.postorderTraversal(root2);
        System.out.println("Output for Example 2: " + result2);


        TreeNode root3 = null;
        List<Integer> result3 = solver.postorderTraversal(root3);
        System.out.println("Output for Example 3: " + result3);


        TreeNode root4 = new TreeNode(1);
        List<Integer> result4 = solver.postorderTraversal(root4);
        System.out.println("Output for Example 4: " + result4);
    }

    static class BinaryTreePostorderTraversal {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            postorder(root, result);
            return result;
        }

        private void postorder(TreeNode node, List<Integer> list){
            if(node == null) return;
            postorder(node.left, list);
            postorder(node.right, list);
            list.add(node.val);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
