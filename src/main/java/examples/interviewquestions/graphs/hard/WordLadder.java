package examples.interviewquestions.graphs.hard;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return steps;
                for (String neighbor : getNeighbors(word)) {
                    if (dict.contains(neighbor)) {
                        dict.remove(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char old = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                arr[i] = c;
                neighbors.add(new String(arr));
            }
            arr[i] = old;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        WordLadder sol = new WordLadder();

        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(sol.ladderLength(beginWord1, endWord1, wordList1)); //  5

        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(sol.ladderLength(beginWord2, endWord2, wordList2)); //  0
    }
}
