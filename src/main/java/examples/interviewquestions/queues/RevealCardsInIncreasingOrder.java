package examples.interviewquestions.queues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indexQueue.add(i);
        }

        int[] result = new int[n];
        for (int card : deck) {
            result[indexQueue.poll()] = card;
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RevealCardsInIncreasingOrder solution = new RevealCardsInIncreasingOrder();
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] result = solution.deckRevealedIncreasing(deck);
        System.out.println(Arrays.toString(result));
    }
}
