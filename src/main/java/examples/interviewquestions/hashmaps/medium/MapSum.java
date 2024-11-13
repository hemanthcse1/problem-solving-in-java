package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    private class TrieNode {
        Map<Character, TrieNode> children;
        int value;

        TrieNode() {
            children = new HashMap<>();
            value = 0;
        }
    }

    private TrieNode root;
    private Map<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);

        TrieNode current = root;
        for (char c : key.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
            current.value += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return 0;
            }
            current = current.children.get(c);
        }
        return current.value;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}
