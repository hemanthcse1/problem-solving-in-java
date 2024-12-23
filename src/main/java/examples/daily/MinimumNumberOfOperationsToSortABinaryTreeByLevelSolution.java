package examples.daily;

import java.util.*;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevelSolution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public int minimumOperations(TreeNode root) {
            if (root == null) return 0;
            int totalOperations = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    currentLevel.add(currentNode.val);

                    if (currentNode.left != null) queue.offer(currentNode.left);
                    if (currentNode.right != null) queue.offer(currentNode.right);
                }

                totalOperations += minSwapsToSort(currentLevel);
            }

            return totalOperations;
        }

        private int minSwapsToSort(List<Integer> arr) {
            int n = arr.size();
            List<Pair> arrPos = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arrPos.add(new Pair(arr.get(i), i));
            }

            arrPos.sort(Comparator.comparingInt(a -> a.val));

            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);

            int swaps = 0;

            for (int i = 0; i < n; i++) {
                if (visited[i] || arrPos.get(i).index == i) {
                    continue;
                }

                int cycleSize = 0;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = arrPos.get(j).index;
                    cycleSize++;
                }

                if (cycleSize > 0) {
                    swaps += (cycleSize - 1);
                }
            }

            return swaps;
        }

        class Pair {
            int val;
            int index;

            Pair(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }
    }

    public static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (current != null) {
                if (i < values.length && values[i] != null) {
                    current.left = new TreeNode(values[i]);
                    queue.offer(current.left);
                } else {
                    current.left = null;
                    queue.offer(null);
                }
                i++;

                if (i < values.length && values[i] != null) {
                    current.right = new TreeNode(values[i]);
                    queue.offer(current.right);
                } else {
                    current.right = null;
                    queue.offer(null);
                }
                i++;
            }
        }
        return root;
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        Integer[] tree1 = {1,4,3,7,6,8,5,null,null,null,null,9,null,10};
        TreeNode root1 = buildTree(tree1);
        System.out.println(solution.minimumOperations(root1));

        Integer[] tree2 = {1,3,2,7,6,5,4};
        TreeNode root2 = buildTree(tree2);
        System.out.println(solution.minimumOperations(root2));

    }
}

