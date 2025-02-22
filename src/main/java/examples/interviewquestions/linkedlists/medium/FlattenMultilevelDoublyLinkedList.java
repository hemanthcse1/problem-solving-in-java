package examples.interviewquestions.linkedlists.medium;

import java.util.Stack;

public class FlattenMultilevelDoublyLinkedList {

    static class Node {
        int val;
        Node next, prev, child;
        Node(int val) { this.val = val; }
    }

    public Node flatten(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        Node current = head;

        while (current != null) {
            if (current.child != null) {
                if (current.next != null) {
                    stack.push(current.next);
                }
                current.next = current.child;
                current.next.prev = current;
                current.child = null;
            }


            if (current.next == null && !stack.isEmpty()) {
                Node nextNode = stack.pop();
                current.next = nextNode;
                nextNode.prev = current;
            }

            current = current.next;
        }

        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1: Creating multilevel list manually
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.child = new Node(7);
        head.next.next.child.next = new Node(8);
        head.next.next.child.next.prev = head.next.next.child;
        head.next.next.child.next.child = new Node(11);
        head.next.next.child.next.child.next = new Node(12);
        head.next.next.child.next.child.next.prev = head.next.next.child.next.child;
        head.next.next.child.next.next = new Node(9);
        head.next.next.child.next.next.prev = head.next.next.child.next;
        head.next.next.child.next.next.next = new Node(10);
        head.next.next.child.next.next.next.prev = head.next.next.child.next.next;

        FlattenMultilevelDoublyLinkedList solution = new FlattenMultilevelDoublyLinkedList();
        Node flattenedHead = solution.flatten(head);
        printList(flattenedHead);
    }
}
