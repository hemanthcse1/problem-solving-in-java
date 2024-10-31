package examples.interviewquestions.strings.medium;

import java.util.*;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (String next : getNextStates(current)) {
                    if (!visited.contains(next) && !deadSet.contains(next)) {
                        if (next.equals(target)) return moves;
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNextStates(String current) {
        List<String> nextStates = new ArrayList<>();
        char[] chars = current.toCharArray();

        for (int i = 0; i < 4; i++) {
            char originalChar = chars[i];

            chars[i] = originalChar == '9' ? '0' : (char)(originalChar + 1);
            nextStates.add(new String(chars));

            chars[i] = originalChar == '0' ? '9' : (char)(originalChar - 1);
            nextStates.add(new String(chars));

            chars[i] = originalChar;
        }
        return nextStates;
    }

    public static void main(String[] args) {
        OpenTheLock solution = new OpenTheLock();

        String[] deadends1 = {"0201","0101","0102","1212","2002"};
        String target1 = "0202";
        System.out.println(solution.openLock(deadends1, target1));

        String[] deadends2 = {"8888"};
        String target2 = "0009";
        System.out.println(solution.openLock(deadends2, target2));

        String[] deadends3 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target3 = "8888";
        System.out.println(solution.openLock(deadends3, target3));
    }
}
