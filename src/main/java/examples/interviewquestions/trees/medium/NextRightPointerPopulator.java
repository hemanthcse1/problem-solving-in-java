package examples.interviewquestions.trees.medium;

public class NextRightPointerPopulator {

    static class TreeNodeWithNext {
        public int val;
        public TreeNodeWithNext left;
        public TreeNodeWithNext right;
        public TreeNodeWithNext next;

        public TreeNodeWithNext(int val) {
            this.val = val;
        }
    }

    public TreeNodeWithNext connect(TreeNodeWithNext root) {
        if (root == null) return null;
        TreeNodeWithNext levelStart = root;
        while (levelStart != null) {
            TreeNodeWithNext dummy = new TreeNodeWithNext(0);
            TreeNodeWithNext tail = dummy;
            TreeNodeWithNext curr = levelStart;
            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next;
            }
            levelStart = dummy.next;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNodeWithNext root = new TreeNodeWithNext(1);
        root.left = new TreeNodeWithNext(2);
        root.right = new TreeNodeWithNext(3);
        root.left.left = new TreeNodeWithNext(4);
        root.left.right = new TreeNodeWithNext(5);
        root.right.right = new TreeNodeWithNext(7);

        NextRightPointerPopulator populator = new NextRightPointerPopulator();
        TreeNodeWithNext result = populator.connect(root);

    }
}
