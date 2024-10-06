package examples.interviewquestions.arrays.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int candy : aliceSizes) sumA += candy;
        for (int candy : bobSizes) sumB += candy;

        int diff = (sumB - sumA) / 2;
        Set<Integer> bobSet = new HashSet<>();
        for (int candy : bobSizes) {
            bobSet.add(candy);
        }

        for (int candy : aliceSizes) {
            int target = candy + diff;
            if (bobSet.contains(target)) {
                return new int[]{candy, target};
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        FairCandySwap solver = new FairCandySwap();
        System.out.println(Arrays.toString(solver.fairCandySwap(new int[]{1,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(solver.fairCandySwap(new int[]{1,2}, new int[]{2,3})));
        System.out.println(Arrays.toString(solver.fairCandySwap(new int[]{2}, new int[]{1,3})));
    }
}
