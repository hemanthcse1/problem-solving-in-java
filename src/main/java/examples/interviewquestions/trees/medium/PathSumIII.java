package examples.interviewquestions.trees.medium;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(-3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        root1.right.right = new TreeNode(11);
        root1.left.left.left = new TreeNode(3);
        root1.left.left.right = new TreeNode(-2);
        root1.left.right.right = new TreeNode(1);

        int targetSum1 = 8;
        System.out.println(pathSum(root1, targetSum1));


        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(11);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.right = new TreeNode(2);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(4);
        root2.right.right.left = new TreeNode(5);
        root2.right.right.right = new TreeNode(1);

        int targetSum2 = 22;
        System.out.println(pathSum(root2, targetSum2));
    }

    public static int pathSum(TreeNode root, int targetSum) {

        Map<Long, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSums);
    }

    private static int dfs(TreeNode node, long currentSum, int target, Map<Long, Integer> prefixSums) {
        if (node == null) {
            return 0;
        }

        currentSum += node.val;


        int count = prefixSums.getOrDefault(currentSum - target, 0);


        prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0) + 1);


        count += dfs(node.left, currentSum, target, prefixSums);
        count += dfs(node.right, currentSum, target, prefixSums);


        prefixSums.put(currentSum, prefixSums.get(currentSum) - 1);
        if (prefixSums.get(currentSum) == 0) {
            prefixSums.remove(currentSum);
        }

        return count;
    }
}
