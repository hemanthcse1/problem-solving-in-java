package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;
import java.util.Map;

public class TrieExample {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode currentNode = root;
            for(char ch : word.toCharArray()) {
                currentNode = currentNode.children.computeIfAbsent(ch, c -> new TrieNode());
            }
            currentNode.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = traverse(word);
            return node != null && node.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            return traverse(prefix) != null;
        }

        private TrieNode traverse(String str) {
            TrieNode currentNode = root;
            for(char ch : str.toCharArray()) {
                currentNode = currentNode.children.get(ch);
                if(currentNode == null) {
                    return null;
                }
            }
            return currentNode;
        }

        private static class TrieNode {
            private final Map<Character, TrieNode> children;
            private boolean isEndOfWord;

            public TrieNode() {
                children = new HashMap<>();
                isEndOfWord = false;
            }
        }
    }
}
