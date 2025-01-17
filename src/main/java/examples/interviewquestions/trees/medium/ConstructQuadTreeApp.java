package examples.interviewquestions.trees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConstructQuadTreeApp {


    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public static Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private static Node build(int[][] grid, int r, int c, int size) {
        if (size == 1) {
            return new Node(grid[r][c] == 1, true);
        }
        if (allSame(grid, r, c, size)) {
            return new Node(grid[r][c] == 1, true);
        }
        int half = size / 2;
        Node topLeft = build(grid, r, c, half);
        Node topRight = build(grid, r, c + half, half);
        Node bottomLeft = build(grid, r + half, c, half);
        Node bottomRight = build(grid, r + half, c + half, half);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private static boolean allSame(int[][] grid, int r, int c, int size) {
        int val = grid[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printQuadTree(Node root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<String> representation = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                representation.add("null");
            } else {
                representation.add("[" + (node.isLeaf ? 1 : 0) + "," + (node.val ? 1 : 0) + "]");
                if (!node.isLeaf) {
                    queue.offer(node.topLeft);
                    queue.offer(node.topRight);
                    queue.offer(node.bottomLeft);
                    queue.offer(node.bottomRight);
                }
            }
        }
        while (!representation.isEmpty() && representation.get(representation.size()-1).equals("null")) {
            representation.remove(representation.size()-1);
        }
        System.out.println(representation);
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0, 1},
                {1, 0}
        };
        Node root1 = construct(grid1);
        printQuadTree(root1);

        int[][] grid2 = {
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}
        };
        Node root2 = construct(grid2);
        printQuadTree(root2);

        int[][] grid3 = {
                {1}
        };
        Node root3 = construct(grid3);
        printQuadTree(root3);
    }
}
