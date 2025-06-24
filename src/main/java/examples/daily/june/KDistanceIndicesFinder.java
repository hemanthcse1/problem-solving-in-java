package examples.daily.june;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class KDistanceIndicesFinder {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);
                int end = Math.min(n - 1, i + k);
                for (int j = start; j <= end; j++) {
                    result.add(j);
                }
            }
        }
        Set<Integer> unique = new TreeSet<>(result);
        return new ArrayList<>(unique);
    }

    public static void main(String[] args) {
        KDistanceIndicesFinder finder = new KDistanceIndicesFinder();
        int[] nums = {3, 4, 9, 1, 3, 9, 5};
        int key = 9;
        int k = 1;
        System.out.println(finder.findKDistantIndices(nums, key, k));  //  [1, 2, 3, 4, 5, 6]
    }
}
