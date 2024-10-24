package examples.interviewquestions.strings.medium;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());

            graph.get(A).put(B, value);
            graph.get(B).put(A, 1.0 / value);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);

            if (!graph.containsKey(C) || !graph.containsKey(D)) {
                results[i] = -1.0;
            } else if (C.equals(D)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(C, D, graph, visited, 1.0);
            }
        }

        return results;
    }

    private double dfs(String current, String target, Map<String, Map<String, Double>> graph, Set<String> visited, double value) {

        if (current.equals(target)) {
            return value;
        }

        visited.add(current);

        Map<String, Double> neighbors = graph.get(current);
        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                double result = dfs(neighbor, target, graph, visited, value * neighbors.get(neighbor));
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();


        List<List<String>> equations1 = Arrays.asList(
                Arrays.asList("a", "b"), Arrays.asList("b", "c")
        );
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = Arrays.asList(
                Arrays.asList("a", "c"), Arrays.asList("b", "a"),
                Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")
        );
        System.out.println(Arrays.toString(solution.calcEquation(equations1, values1, queries1)));

        List<List<String>> equations2 = Arrays.asList(
                Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("bc", "cd")
        );
        double[] values2 = {1.5, 2.5, 5.0};
        List<List<String>> queries2 = Arrays.asList(
                Arrays.asList("a", "c"), Arrays.asList("c", "b"), Arrays.asList("bc", "cd"), Arrays.asList("cd", "bc")
        );
        System.out.println(Arrays.toString(solution.calcEquation(equations2, values2, queries2)));

    }
}
