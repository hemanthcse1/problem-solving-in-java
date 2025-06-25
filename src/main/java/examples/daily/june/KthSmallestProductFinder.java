package examples.daily.june;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestProductFinder {

    public static void main(String[] args) {
        KthSmallestProductFinder kthSmallestProductFinder = new KthSmallestProductFinder();

        int[] nums1 = {-4, -2, 0, 3};
        int[] nums2 = {2, 4};
        long k = 6;

        long result = kthSmallestProductFinder.kthSmallestProduct(nums1, nums2, k);
        System.out.println("The " + k + "-th smallest product is: " + result);
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        List<Integer> neg1 = new ArrayList<>();
        List<Integer> pos1 = new ArrayList<>();
        List<Integer> neg2 = new ArrayList<>();
        List<Integer> pos2 = new ArrayList<>();

        divide(nums1, neg1, pos1);
        divide(nums2, neg2, pos2);

        long negativeProductCount = (long) neg1.size() * pos2.size() + (long) pos1.size() * neg2.size();
        int sign = 1;

        if (k > negativeProductCount) {
            k -= negativeProductCount;
        } else {
            k = negativeProductCount - k + 1;
            sign = -1;
            List<Integer> temp = neg2;
            neg2 = pos2;
            pos2 = temp;
        }

        long left = 0, right = (long) 1e10;
        while (left < right) {
            long mid = (left + right) / 2;
            long count = countProducts(neg1, neg2, mid) + countProducts(pos1, pos2, mid);
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return sign * left;
    }

    private void divide(int[] nums, List<Integer> negatives, List<Integer> positives) {
        for (int num : nums) {
            if (num < 0) {
                negatives.add(-num);
            } else {
                positives.add(num);
            }
        }
        Collections.reverse(negatives);
    }

    private long countProducts(List<Integer> list1, List<Integer> list2, long limit) {
        long count = 0;
        int j = list2.size() - 1;
        for (long a : list1) {
            while (j >= 0 && a * list2.get(j) > limit) {
                j--;
            }
            count += j + 1;
        }
        return count;
    }
}
