package examples.interviewquestions.graphs.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphCloner {
    static class GraphNode {
        public int val;
        public List<GraphNode> neighbors;
        public GraphNode(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    private Map<GraphNode, GraphNode> visited = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        GraphNode clone = new GraphNode(node.val);
        visited.put(node, clone);
        for (GraphNode neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }

    public static void main(String[] args) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        GraphCloner cloner = new GraphCloner();
        GraphNode cloned = cloner.cloneGraph(n1);
        System.out.println("Original Node 1: " + n1.val);
        System.out.println("Cloned Node 1: " + cloned.val);
    }
}
