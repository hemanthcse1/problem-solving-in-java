package examples.interviewquestions.linkedlists.medium;

import java.util.HashMap;

public class LRUCacheImplementation {

    static class LRUCache {
        private static class Node {
            int key, value;
            Node prev, next;
            Node(int k, int v) {
                key = k;
                value = v;
            }
        }

        private final HashMap<Integer, Node> map;
        private final int capacity;
        private final Node head;
        private final Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addToHead(newNode);
                if (map.size() > capacity) {
                    Node lru = tail.prev;
                    removeNode(lru);
                    map.remove(lru.key);
                }
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(Node node) {
            Node p = node.prev;
            Node n = node.next;
            p.next = n;
            n.prev = p;
        }

        private void addToHead(Node node) {
            Node tmp = head.next;
            head.next = node;
            node.prev = head;
            node.next = tmp;
            tmp.prev = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }
}
