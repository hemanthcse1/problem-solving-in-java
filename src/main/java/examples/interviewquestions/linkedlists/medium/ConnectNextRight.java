package examples.interviewquestions.linkedlists.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNextRight {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        ConnectNextRight solution = new ConnectNextRight();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        solution.connect(root);

        printNextPointers(root);
    }

    private static void printNextPointers(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node curr = levelStart;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("NULL");
            levelStart = levelStart.left;
        }
    }
}
