package examples.interviewquestions.queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating {
    public static void findFirstNonRepeating(String stream) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : stream.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            queue.add(c);

            while (!queue.isEmpty() && charCount.get(queue.peek()) > 1) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                System.out.println("First non-repeating character is: " + queue.peek());
            } else {
                System.out.println("No non-repeating character found.");
            }
        }
    }

    public static void main(String[] args) {
        String stream = "aabc";
        findFirstNonRepeating(stream);
    }
}
