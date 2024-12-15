package examples.daily;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio {

    static class ClassInfo {
        int pass;
        int total;

        ClassInfo(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }

        double improvementIfAddOne() {
            double currentRatio = (double) pass / total;
            double newRatio = (double) (pass + 1) / (total + 1);
            return newRatio - currentRatio;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> maxHeap = new PriorityQueue<>((a, b) -> {
            double diff = b.improvementIfAddOne() - a.improvementIfAddOne();
            return diff > 0 ? 1 : (diff < 0 ? -1 : 0);
        });

        for (int[] c : classes) {
            maxHeap.offer(new ClassInfo(c[0], c[1]));
        }

        for (int i = 0; i < extraStudents; i++) {
            ClassInfo ci = maxHeap.poll();
            ci.pass += 1;
            ci.total += 1;
            maxHeap.offer(ci);
        }

        double sum = 0.0;
        int n = classes.length;
        while (!maxHeap.isEmpty()) {
            ClassInfo ci = maxHeap.poll();
            sum += (double) ci.pass / ci.total;
        }

        return sum / n;
    }

    public static void main(String[] args) {
        MaximumAveragePassRatio solver = new MaximumAveragePassRatio();

        int[][] classes1 = {{1, 2}, {3, 5}, {2, 2}};
        int extra1 = 2;
        System.out.println(solver.maxAverageRatio(classes1, extra1));

        int[][] classes2 = {{2,4},{3,9},{4,5},{2,10}};
        int extra2 = 4;
        System.out.println(solver.maxAverageRatio(classes2, extra2));
    }
}
