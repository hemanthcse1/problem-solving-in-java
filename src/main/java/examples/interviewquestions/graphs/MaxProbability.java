package examples.interviewquestions.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxProbability {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;


        double result = maxProbability(n, edges, succProb, start, end);
        System.out.println(result);
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double w = succProb[i];
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }

        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start] = 1.0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Node(start, 1.0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.index;
            double prob = curr.prob;
            if (u == end) {
                return prob;
            }

            if (prob < dist[u]) {
                continue;
            }

            for (Node neighbor : graph.get(u)) {
                double newProb = prob * neighbor.prob;
                if (newProb > dist[neighbor.index]) {
                    dist[neighbor.index] = newProb;
                    pq.offer(new Node(neighbor.index, newProb));
                }
            }
        }

        return 0.0;
    }
}

class Node {
    int index;
    double prob;
    Node(int index, double prob) {
        this.index = index;
        this.prob = prob;
    }
}
