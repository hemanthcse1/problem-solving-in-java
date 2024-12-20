package examples.daily;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class ReverseOddLevelsBinaryTree {

    public static TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        reverseHelper(root.left, root.right, 1);
        return root;
    }

    private static void reverseHelper(TreeNode left, TreeNode right, int level){
        if (left == null || right == null) return;
        if (level %2 ==1){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        reverseHelper(left.left, right.right, level+1);
        reverseHelper(left.right, right.left, level+1);
    }

    public static void main(String[] args) {
        Integer[] arr1 = {2,3,5,8,13,21,34};
        TreeNode root1 = buildTree(arr1);
        TreeNode result1 = reverseOddLevels(root1);
        System.out.println(Arrays.toString(treeToArray(result1)));


        Integer[] arr2 = {7,13,11};
        TreeNode root2 = buildTree(arr2);
        TreeNode result2 = reverseOddLevels(root2);
        System.out.println(Arrays.toString(treeToArray(result2)));

        // Example 3
        Integer[] arr3 = {0,1,2,0,0,0,0,1,1,1,1,2,2,2,2};
        TreeNode root3 = buildTree(arr3);
        TreeNode result3 = reverseOddLevels(root3);
        System.out.println(Arrays.toString(treeToArray(result3)));
    }

    private static TreeNode buildTree(Integer[] arr){
        if (arr.length ==0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1;
        while(i < arr.length){
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != null){
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null){
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    private static Integer[] treeToArray(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current != null){
                list.add(current.val);
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                list.add(null);
            }
        }
        while(list.size() >0 && list.get(list.size()-1) == null){
            list.remove(list.size()-1);
        }
        return list.toArray(new Integer[0]);
    }
}
