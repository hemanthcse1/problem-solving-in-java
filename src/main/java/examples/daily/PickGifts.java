package examples.daily;

import java.util.Collections;
import java.util.PriorityQueue;

public class PickGifts {

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int g : gifts) pq.offer((long)g);
        for (int i = 0; i < k; i++) {
            long max = pq.poll();
            long remain = (long)Math.floor(Math.sqrt(max));
            pq.offer(remain);
        }
        long sum = 0;
        while (!pq.isEmpty()) sum += pq.poll();
        return sum;
    }

    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};
        int k = 4;
        System.out.println(pickGifts(gifts, k));
    }

}
