package examples.interviewquestions.strings.medium;

import java.util.*;

public class MinimumGeneticMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) return mutations;

                char[] currentArray = current.toCharArray();
                for (int j = 0; j < currentArray.length; j++) {
                    char originalChar = currentArray[j];
                    for (char gene : genes) {
                        if (gene == originalChar) continue;
                        currentArray[j] = gene;
                        String nextMutation = new String(currentArray);

                        if (bankSet.contains(nextMutation) && !visited.contains(nextMutation)) {
                            visited.add(nextMutation);
                            queue.offer(nextMutation);
                        }
                    }
                    currentArray[j] = originalChar;
                }
            }
            mutations++;
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation solution = new MinimumGeneticMutation();

        System.out.println(solution.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(solution.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}
