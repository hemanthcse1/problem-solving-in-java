package examples.interviewquestions.hashmaps.medium;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestInfiniteSet {

    private PriorityQueue<Integer> minHeap;
    private HashSet<Integer> addedBackSet;
    private int nextSmallest;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        addedBackSet = new HashSet<>();
        nextSmallest = 1;
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            addedBackSet.remove(smallest);
            return smallest;
        }
        return nextSmallest++;
    }

    public void addBack(int num) {
        if (num < nextSmallest && !addedBackSet.contains(num)) {
            minHeap.add(num);
            addedBackSet.add(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }
}
