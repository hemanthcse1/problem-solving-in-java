package examples.interviewquestions.trees.medium;

public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);


        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }


    public static void main(String[] args) {
        // Sample Tree: [3,5,1,6,2,0,8,null,null,7,4]
        /*
                3
               / \
              5   1
             / \  / \
            6  2 0  8
              / \
             7   4
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;
        TreeNode q = root.right;
        LowestCommonAncestor solver = new LowestCommonAncestor();
        TreeNode result1 = solver.lowestCommonAncestor(root, p, q);
        System.out.println(result1.val);

        TreeNode p2 = root.left;
        TreeNode q2 = root.left.right.right;
        TreeNode result2 = solver.lowestCommonAncestor(root, p2, q2);
        System.out.println(result2.val);

        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        TreeNode p3 = r;
        TreeNode q3 = r.left;
        TreeNode result3 = solver.lowestCommonAncestor(r, p3, q3);
        System.out.println(result3.val);
    }
}
