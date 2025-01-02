package examples.interviewquestions.linkedlists.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node copy = map.get(current);
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

    public String serializeList(Node head) {
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        Node current = head;
        int index = 0;
        while (current != null) {
            nodeToIndex.put(current, index++);
            current = current.next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        current = head;
        while (current != null) {
            sb.append("[").append(current.val).append(",");
            if (current.random != null) {
                sb.append(nodeToIndex.get(current.random));
            } else {
                sb.append("null");
            }
            sb.append("]");
            current = current.next;
            if (current != null) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public Node buildList(int[][] connections) {
        if (connections.length == 0) return null;
        Node[] nodes = new Node[connections.length];
        for (int i = 0; i < connections.length; i++) {
            nodes[i] = new Node(connections[i][0]);
        }
        for (int i = 0; i < connections.length; i++) {
            if (i < connections.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
            if (connections[i][1] != -1) {
                nodes[i].random = nodes[connections[i][1]];
            }
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();

        int[][] input1 = {{7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node head1 = solution.buildList(input1);
        Node copiedHead1 = solution.copyRandomList(head1);
        System.out.println(solution.serializeList(copiedHead1));

        int[][] input2 = {{1, 1}, {2, 1}};
        Node head2 = solution.buildList(input2);
        Node copiedHead2 = solution.copyRandomList(head2);
        System.out.println(solution.serializeList(copiedHead2));

        int[][] input3 = {{3, -1}, {3, 0}, {3, -1}};
        Node head3 = solution.buildList(input3);
        Node copiedHead3 = solution.copyRandomList(head3);
        System.out.println(solution.serializeList(copiedHead3));
    }
}
