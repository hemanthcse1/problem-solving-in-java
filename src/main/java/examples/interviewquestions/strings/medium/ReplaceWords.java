package examples.interviewquestions.strings.medium;

import java.util.List;

public class ReplaceWords {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private void insert(String word, TrieNode root) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }
    private String findRoot(String word, TrieNode root) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return word;
            }
            node = node.children[index];
            if (node.word != null) {
                return node.word;
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            insert(word, root);
        }

        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(findRoot(word, root));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();

        List<String> dictionary = List.of("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords.replaceWords(dictionary, sentence));

        dictionary = List.of("a", "b", "c");
        sentence = "aadsfasf absbs bbab cadsfafs";
        System.out.println(replaceWords.replaceWords(dictionary, sentence));
    }
}
