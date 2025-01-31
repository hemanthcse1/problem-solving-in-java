package examples.interviewquestions.graphs.hard;

import java.util.*;

public class WordSearchII {
    private static final int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private Set<String> result;
    private TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        root = new TrieNode();

        for (String word : words) {
            insertWord(word);
        }

        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.children.containsKey(board[i][j])) {
                    dfs(board, i, j, root, "");
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void insertWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.word = word;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, String currentWord) {
        char c = board[i][j];
        if (!node.children.containsKey(c)) return;

        node = node.children.get(c);
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        for (int[] d : directions) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length && board[ni][nj] != '#') {
                dfs(board, ni, nj, node, currentWord + c);
            }
        }
        board[i][j] = c;

        if (node.children.isEmpty()) {
            node = null;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    public static void main(String[] args) {
        WordSearchII solution = new WordSearchII();
        char[][] board1 = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words1 = {"oath", "pea", "eat", "rain"};
        System.out.println(solution.findWords(board1, words1)); // ["eat", "oath"]

        char[][] board2 = {
                {'a','b'},
                {'c','d'}
        };
        String[] words2 = {"abcb"};
        System.out.println(solution.findWords(board2, words2)); // []
    }
}
