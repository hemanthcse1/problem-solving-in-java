package examples.interviewquestions.hashmaps.medium;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        pq.add(1L);
        seen.add(1L);
        long current = 1;

        for (int i = 0; i < n; i++) {
            current = pq.poll();
            for (int factor : factors) {
                long next = current * factor;
                if (!seen.contains(next)) {
                    pq.add(next);
                    seen.add(next);
                }
            }
        }
        return (int) current;
    }

    public static void main(String[] args) {
        UglyNumberII solution = new UglyNumberII();
        System.out.println(solution.nthUglyNumber(10));
    }
}
