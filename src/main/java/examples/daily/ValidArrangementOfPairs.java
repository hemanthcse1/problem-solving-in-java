package examples.daily;

import java.util.*;

public class ValidArrangementOfPairs {

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];

            graph.putIfAbsent(start, new Stack<>());
            graph.putIfAbsent(end, new Stack<>());

            graph.get(start).push(end);

            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        int startNode = pairs[0][0];
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) > inDegree.getOrDefault(node, 0)) {
                startNode = node;
                break;
            }
        }

        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int curr = stack.peek();
            if (graph.get(curr).isEmpty()) {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[]{stack.peek(), curr});
                }
            } else {
                stack.push(graph.get(curr).pop());
            }
        }

        Collections.reverse(result);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        ValidArrangementOfPairs solution = new ValidArrangementOfPairs();

        int[][] pairs1 = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
        System.out.println(Arrays.deepToString(solution.validArrangement(pairs1)));

        int[][] pairs2 = {{1, 3}, {3, 2}, {2, 1}};
        System.out.println(Arrays.deepToString(solution.validArrangement(pairs2)));

    }
}
