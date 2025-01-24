package examples.daily.medium.january;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes {

    private static final int VISITING = 1;
    private static final int SAFE = 2;
    private static final int UNSAFE = 3;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, state, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[][] graph, int[] state, int node) {
        if (state[node] == VISITING) {
            state[node] = UNSAFE;
            return false;
        }
        if (state[node] == SAFE) return true;
        if (state[node] == UNSAFE) return false;

        state[node] = VISITING;
        for (int next : graph[node]) {
            if (!dfs(graph, state, next)) {
                state[node] = UNSAFE;
                return false;
            }
        }
        state[node] = SAFE;
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1,2},{2,3},{5},{0},{5},{},{}};
        int[][] graph2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};

        EventualSafeNodes sol = new EventualSafeNodes();

        System.out.println(sol.eventualSafeNodes(graph1));
        System.out.println(sol.eventualSafeNodes(graph2));
    }
}
