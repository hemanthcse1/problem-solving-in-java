package examples.interviewquestions.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> high;

    public MedianFinder() {
        low = new PriorityQueue<>(Collections.reverseOrder());
        high = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (low.isEmpty() || num <= low.peek()) {
            low.offer(num);
        } else {
            high.offer(num);
        }

        if (low.size() > high.size() + 1) {
            high.offer(low.poll());
        } else if (high.size() > low.size()) {
            low.offer(high.poll());
        }
    }

    public double findMedian() {
        if (low.size() == high.size()) {
            return (low.peek() + high.peek()) / 2.0;
        }
        return low.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); //  1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); //  2.0
    }
}
