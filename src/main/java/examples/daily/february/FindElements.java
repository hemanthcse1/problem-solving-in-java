package examples.daily.february;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindElements {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    private Set<Integer> recoveredValues;

    public FindElements(TreeNode root) {
        recoveredValues = new HashSet<>();
        recoverTree(root, 0);
    }

    private void recoverTree(TreeNode node, int value) {
        if (node == null) return;

        node.val = value;
        recoveredValues.add(value);

        recoverTree(node.left, 2 * value + 1);
        recoverTree(node.right, 2 * value + 2);
    }

    public boolean find(int target) {
        return recoveredValues.contains(target);
    }


    public static TreeNode createBinaryTree(Integer[] values) {
        if (values.length == 0) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {

        Integer[] tree1 = {-1, null, -1};
        FindElements findElements1 = new FindElements(createBinaryTree(tree1));
        System.out.println(findElements1.find(1)); //  false
        System.out.println(findElements1.find(2)); //  true


        Integer[] tree2 = {-1, -1, -1, -1, -1};
        FindElements findElements2 = new FindElements(createBinaryTree(tree2));
        System.out.println(findElements2.find(1)); //  true
        System.out.println(findElements2.find(3)); //  true
        System.out.println(findElements2.find(5)); //  false


    }
}
