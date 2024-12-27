package examples.interviewquestions.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long totalCost = 0;

        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        };

        PriorityQueue<int[]> leftHeap = new PriorityQueue<>(comparator);
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>(comparator);

        int leftIndex = 0;
        int rightIndex = n - 1;

        for (; leftIndex < candidates && leftIndex <= rightIndex; leftIndex++) {
            leftHeap.offer(new int[]{costs[leftIndex], leftIndex});
        }

        for (; rightIndex >= n - candidates && rightIndex >= leftIndex; rightIndex--) {
            rightHeap.offer(new int[]{costs[rightIndex], rightIndex});
        }

        for (int i = 0; i < k; i++) {
            if (leftHeap.isEmpty() && rightHeap.isEmpty()) {
                break;
            }

            int[] leftTop = leftHeap.isEmpty() ? null : leftHeap.peek();
            int[] rightTop = rightHeap.isEmpty() ? null : rightHeap.peek();

            if (leftTop != null && rightTop != null) {
                if (leftTop[0] < rightTop[0]) {
                    totalCost += leftHeap.poll()[0];
                    if (leftIndex <= rightIndex) {
                        leftHeap.offer(new int[]{costs[leftIndex], leftIndex});
                        leftIndex++;
                    }
                } else if (leftTop[0] > rightTop[0]) {
                    totalCost += rightHeap.poll()[0];
                    if (leftIndex <= rightIndex) {
                        rightHeap.offer(new int[]{costs[rightIndex], rightIndex});
                        rightIndex--;
                    }
                } else {
                    if (leftTop[1] < rightTop[1]) {
                        totalCost += leftHeap.poll()[0];
                        if (leftIndex <= rightIndex) {
                            leftHeap.offer(new int[]{costs[leftIndex], leftIndex});
                            leftIndex++;
                        }
                    } else {
                        totalCost += rightHeap.poll()[0];
                        if (leftIndex <= rightIndex) {
                            rightHeap.offer(new int[]{costs[rightIndex], rightIndex});
                            rightIndex--;
                        }
                    }
                }
            } else if (leftTop != null) {
                totalCost += leftHeap.poll()[0];
                if (leftIndex <= rightIndex) {
                    leftHeap.offer(new int[]{costs[leftIndex], leftIndex});
                    leftIndex++;
                }
            } else if (rightTop != null) {
                totalCost += rightHeap.poll()[0];
                if (leftIndex <= rightIndex) {
                    rightHeap.offer(new int[]{costs[rightIndex], rightIndex});
                    rightIndex--;
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        TotalCostToHireKWorkers solution = new TotalCostToHireKWorkers();

        int[] costs1 = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k1 = 3;
        int candidates1 = 4;
        System.out.println("Example 1 Output: " + solution.totalCost(costs1, k1, candidates1));

        int[] costs2 = {1, 2, 4, 1};
        int k2 = 3;
        int candidates2 = 3;
        System.out.println("Example 2 Output: " + solution.totalCost(costs2, k2, candidates2));

        int[] costs3 = {5, 5, 4, 4, 4, 5};
        int k3 = 2;
        int candidates3 = 2;
        System.out.println("Additional Test Case Output: " + solution.totalCost(costs3, k3, candidates3));
    }
}
