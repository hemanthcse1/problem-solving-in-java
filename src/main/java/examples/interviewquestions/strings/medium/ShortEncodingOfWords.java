package examples.interviewquestions.strings.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortEncodingOfWords {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    public int minimumLengthEncoding(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        TrieNode root = new TrieNode();
        Map<TrieNode, Integer> leafNodes = new HashMap<>();

        for (String word : uniqueWords) {
            TrieNode current = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            leafNodes.put(current, word.length());
        }

        int totalLength = 0;
        for (TrieNode node : leafNodes.keySet()) {
            if (node.children.isEmpty()) {
                totalLength += leafNodes.get(node) + 1;
            }
        }

        return totalLength;
    }

    public static void main(String[] args) {
        ShortEncodingOfWords solution = new ShortEncodingOfWords();

        String[] words1 = {"time", "me", "bell"};
        System.out.println(solution.minimumLengthEncoding(words1));

        String[] words2 = {"t"};
        System.out.println(solution.minimumLengthEncoding(words2));
    }
}
