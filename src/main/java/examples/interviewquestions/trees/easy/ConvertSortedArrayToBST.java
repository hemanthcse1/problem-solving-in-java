package examples.interviewquestions.trees.easy;

public class ConvertSortedArrayToBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST converter = new ConvertSortedArrayToBST();

        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = converter.sortedArrayToBST(nums1);

        int[] nums2 = {1, 3};
        TreeNode root2 = converter.sortedArrayToBST(nums2);
    }
}
