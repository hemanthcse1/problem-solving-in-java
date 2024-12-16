package examples.interviewquestions.trees.easy;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversalMain {

    public static void main(String[] args) {
        NAryTreePostorderTraversal solver = new NAryTreePostorderTraversal();

        Node root1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        root1.children.add(node3);
        root1.children.add(node2);
        root1.children.add(node4);
        node3.children.add(node5);
        node3.children.add(node6);
        List<Integer> result1 = solver.postorder(root1);
        System.out.println("Output for Example 1: " + result1);

        Node root2 = new Node(1);
        Node node2_2 = new Node(2);
        Node node3_2 = new Node(3);
        Node node4_2 = new Node(4);
        Node node5_2 = new Node(5);
        Node node6_2 = new Node(6);
        Node node7_2 = new Node(7);
        Node node8_2 = new Node(8);
        Node node9_2 = new Node(9);
        Node node10_2 = new Node(10);
        Node node11_2 = new Node(11);
        Node node12_2 = new Node(12);
        Node node13_2 = new Node(13);
        Node node14_2 = new Node(14);

        root2.children.add(node2_2);
        root2.children.add(node3_2);
        root2.children.add(node4_2);
        root2.children.add(node5_2);

        node3_2.children.add(node6_2);
        node3_2.children.add(node7_2);

        node5_2.children.add(node8_2);
        node5_2.children.add(node9_2);
        node5_2.children.add(node10_2);

        node8_2.children.add(node11_2);
        node11_2.children.add(node12_2);
        node12_2.children.add(node13_2);
        node13_2.children.add(node14_2);

        List<Integer> result2 = solver.postorder(root2);
        System.out.println("Output for Example 2: " + result2);

        Node root3 = null;
        List<Integer> result3 = solver.postorder(root3);
        System.out.println("Output for Example 3: " + result3);

        Node root4 = new Node(1);
        List<Integer> result4 = solver.postorder(root4);
        System.out.println("Output for Example 4: " + result4);
    }

    static class NAryTreePostorderTraversal {
        public List<Integer> postorder(Node root) {
            List<Integer> result = new ArrayList<>();
            postorderHelper(root, result);
            return result;
        }

        private void postorderHelper(Node node, List<Integer> list) {
            if (node == null) return;
            for (Node child : node.children) {
                postorderHelper(child, list);
            }
            list.add(node.val);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children != null ? _children : new ArrayList<>();
        }
    }
}
