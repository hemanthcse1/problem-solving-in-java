package examples.interviewquestions.trees.easy;

public class CountCompleteTreeNodes {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) {

            return (1 << leftHeight) + countNodes(root.right);
        } else {

            return (1 << rightHeight) + countNodes(root.left);
        }
    }


    private int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \  /
            4  5 6
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        CountCompleteTreeNodes sol = new CountCompleteTreeNodes();
        System.out.println(sol.countNodes(root));
    }


}
